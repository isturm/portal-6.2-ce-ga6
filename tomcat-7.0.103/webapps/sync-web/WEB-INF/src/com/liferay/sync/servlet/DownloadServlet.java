/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sync.servlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.servlet.Range;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.zip.ZipWriter;
import com.liferay.portal.kernel.zip.ZipWriterFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.ImageConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ImageServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileVersionException;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.sync.SyncSiteUnavailableException;
import com.liferay.sync.model.SyncDLFileVersionDiff;
import com.liferay.sync.service.SyncDLFileVersionDiffLocalServiceUtil;
import com.liferay.sync.util.PortletPropsValues;
import com.liferay.sync.util.SyncUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Dennis Ju
 */
public class DownloadServlet extends HttpServlet {


	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		try {
			HttpSession session = request.getSession();

			if (PortalSessionThreadLocal.getHttpSession() == null) {
				PortalSessionThreadLocal.setHttpSession(session);
			}

			User user = PortalUtil.getUser(request);

			PermissionChecker permissionChecker =
				PermissionCheckerFactoryUtil.create(user);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			String path = HttpUtil.fixPath(request.getPathInfo());
			String[] pathArray = StringUtil.split(path, CharPool.SLASH);

			if (pathArray[0].equals("image")) {
				long imageId = GetterUtil.getLong(pathArray[1]);

				sendImage(response, imageId);
			}
			else if (pathArray[0].equals("zip")) {
				String zipFileIds = ParamUtil.get(
					request, "zipFileIds", StringPool.BLANK);

				if (Validator.isNull(zipFileIds)) {
					throw new IllegalArgumentException(
						"Missing parameter zipFileIds");
				}

				JSONArray zipFileIdsJSONArray = JSONFactoryUtil.createJSONArray(
					zipFileIds);

				sendZipFile(response, user.getUserId(), zipFileIdsJSONArray);
			}
			else if (pathArray[0].equals("zipfolder")) {
				long repositoryId = ParamUtil.getLong(request, "repositoryId");
				long folderId = ParamUtil.getLong(request, "folderId");

				if (repositoryId == 0) {
					throw new IllegalArgumentException(
						"Missing parameter repositoryId");
				}
				else if (folderId == 0) {
					throw new IllegalArgumentException(
						"Missing parameter folderId");
				}

				sendZipFolder(
					response, user.getUserId(), repositoryId, folderId);
			}
			else {
				long groupId = GetterUtil.getLong(pathArray[0]);
				String uuid = pathArray[1];

				Group group = GroupLocalServiceUtil.fetchGroup(groupId);

				if ((group == null) || !SyncUtil.isSyncEnabled(group)) {
					response.setHeader(
						_ERROR_HEADER,
						SyncSiteUnavailableException.class.getName());

					ServletResponseUtil.write(response, new byte[0]);

					return;
				}

				boolean patch = ParamUtil.getBoolean(request, "patch");

				if (patch) {
					sendPatch(
						request, response, user.getUserId(), groupId, uuid);
				}
				else {
					sendFile(
						request, response, user.getUserId(), groupId, uuid);
				}
			}
		}
		catch (NoSuchFileEntryException nsfee) {
			PortalUtil.sendError(
				HttpServletResponse.SC_NOT_FOUND, nsfee, request, response);
		}
		catch (NoSuchFileVersionException nsfve) {
			PortalUtil.sendError(
				HttpServletResponse.SC_NOT_FOUND, nsfve, request, response);
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);
		}
	}

	protected void addZipFolderEntry(
			long userId, long repositoryId, long folderId, String folderPath,
			ZipWriter zipWriter)
		throws Exception {

		List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
			repositoryId, folderId);

		for (FileEntry fileEntry : fileEntries) {
			InputStream inputStream =
				DLFileEntryLocalServiceUtil.getFileAsStream(
					userId, fileEntry.getFileEntryId(), fileEntry.getVersion(),
					false);

			String filePath = folderPath + fileEntry.getTitle();

			zipWriter.addEntry(filePath, inputStream);
		}

		List<Folder> childFolders = DLAppServiceUtil.getFolders(
			repositoryId, folderId);

		for (Folder childFolder : childFolders) {
			String childFolderPath =
				folderPath + childFolder.getName() + StringPool.FORWARD_SLASH;

			addZipFolderEntry(
				userId, repositoryId, childFolder.getFolderId(),
				childFolderPath, zipWriter);
		}
	}

	protected File getDeltaFile(
			long userId, long fileEntryId, long sourceVersionId,
			long targetVersionId)
		throws Exception {

		DLFileVersion sourceDLFileVersion =
			DLFileVersionLocalServiceUtil.getDLFileVersion(sourceVersionId);

		File sourceFile = DLFileEntryLocalServiceUtil.getFile(
			userId, fileEntryId, sourceDLFileVersion.getVersion(), false);

		DLFileVersion targetDLFileVersion =
			DLFileVersionLocalServiceUtil.getDLFileVersion(targetVersionId);

		File targetFile = DLFileEntryLocalServiceUtil.getFile(
			userId, fileEntryId, targetDLFileVersion.getVersion(), false);

		return SyncUtil.getFileDelta(sourceFile, targetFile);
	}

	protected DownloadServletInputStream getFileDownloadServletInputStream(
			long userId, long groupId, String uuid, String version,
			long versionId)
		throws Exception {

		FileEntry fileEntry = DLAppServiceUtil.getFileEntryByUuidAndGroupId(
			uuid, groupId);

		if (fileEntry.isInTrash()) {
			throw new NoSuchFileEntryException();
		}

		if (Validator.isNull(version)) {
			InputStream inputStream =
				DLFileEntryLocalServiceUtil.getFileAsStream(
					userId, fileEntry.getFileEntryId(), fileEntry.getVersion(),
					false);

			String fileName = fileEntry.getTitle();

			String extension = fileEntry.getExtension();

			if (Validator.isNotNull(extension) &&
				!fileName.endsWith(StringPool.PERIOD + extension)) {

				fileName += StringPool.PERIOD + extension;
			}

			return new DownloadServletInputStream(
				inputStream, fileName, fileEntry.getMimeType(),
				fileEntry.getSize());
		}
		else {
			if (versionId > 0) {
				DLFileVersion dlFileVersion =
					DLFileVersionLocalServiceUtil.fetchDLFileVersion(versionId);

				String fileName = dlFileVersion.getTitle();

				String extension = dlFileVersion.getExtension();

				if (Validator.isNotNull(extension) &&
					!fileName.endsWith(StringPool.PERIOD + extension)) {

					fileName += StringPool.PERIOD + extension;
				}

				return new DownloadServletInputStream(
					dlFileVersion.getContentStream(false), fileName,
					dlFileVersion.getMimeType(), dlFileVersion.getSize());
			}
			else {
				FileVersion fileVersion = fileEntry.getFileVersion(version);

				String fileName = fileVersion.getTitle();

				String extension = fileVersion.getExtension();

				if (Validator.isNotNull(extension) &&
					!fileName.endsWith(StringPool.PERIOD + extension)) {

					fileName += StringPool.PERIOD + extension;
				}

				return new DownloadServletInputStream(
					fileVersion.getContentStream(false), fileName,
					fileVersion.getMimeType(), fileVersion.getSize());
			}
		}
	}

	protected DownloadServletInputStream getPatchDownloadServletInputStream(
			long userId, long groupId, String uuid, long sourceVersionId,
			long targetVersionId)
		throws Exception {

		FileEntry fileEntry = DLAppServiceUtil.getFileEntryByUuidAndGroupId(
			uuid, groupId);

		if (fileEntry.isInTrash()) {
			throw new NoSuchFileEntryException();
		}

		if (!PortletPropsValues.SYNC_FILE_DIFF_CACHE_ENABLED) {
			File deltaFile = null;

			try {
				deltaFile = getDeltaFile(
					userId, fileEntry.getFileEntryId(), sourceVersionId,
					targetVersionId);

				return new DownloadServletInputStream(
					new FileInputStream(deltaFile), deltaFile.length());
			}
			finally {
				FileUtil.delete(deltaFile);
			}
		}

		SyncDLFileVersionDiff syncDLFileVersionDiff =
			SyncDLFileVersionDiffLocalServiceUtil.fetchSyncDLFileVersionDiff(
				fileEntry.getFileEntryId(), sourceVersionId, targetVersionId);

		if (syncDLFileVersionDiff != null) {
			SyncDLFileVersionDiffLocalServiceUtil.refreshExpirationDate(
				syncDLFileVersionDiff.getSyncDLFileVersionDiffId());

			FileEntry dataFileEntry =
				PortletFileRepositoryUtil.getPortletFileEntry(
					syncDLFileVersionDiff.getDataFileEntryId());

			return new DownloadServletInputStream(
				dataFileEntry.getContentStream(), dataFileEntry.getSize());
		}
		else {
			File deltaFile = null;

			try {
				deltaFile = getDeltaFile(
					userId, fileEntry.getFileEntryId(), sourceVersionId,
					targetVersionId);

				try {
					SyncDLFileVersionDiffLocalServiceUtil.
						addSyncDLFileVersionDiff(
							fileEntry.getFileEntryId(), sourceVersionId,
							targetVersionId, deltaFile);
				}
				catch (DuplicateFileException dfe) {
				}

				return new DownloadServletInputStream(
					new FileInputStream(deltaFile), deltaFile.length());
			}
			finally {
				FileUtil.delete(deltaFile);
			}
		}
	}

	protected void processException(
		String zipFileId, String exception, JSONObject errorsJSONObject) {

		JSONObject exceptionJSONObject = JSONFactoryUtil.createJSONObject();

		exceptionJSONObject.put("exception", exception);

		errorsJSONObject.put(zipFileId, exceptionJSONObject);
	}

	protected void sendFile(
			HttpServletRequest request, HttpServletResponse response,
			long userId, long groupId, String uuid)
		throws Exception {

		String version = ParamUtil.getString(request, "version");
		long versionId = ParamUtil.getLong(request, "versionId");

		DownloadServletInputStream downloadServletInputStream =
			getFileDownloadServletInputStream(
				userId, groupId, uuid, version, versionId);

		if (request.getHeader(HttpHeaders.RANGE) != null) {
			sendFileWithRangeHeader(
				request, response, downloadServletInputStream.getFileName(),
				downloadServletInputStream.getInputStream(),
				downloadServletInputStream.getSize(),
				downloadServletInputStream.getMimeType());
		}
		else {
			ServletResponseUtil.write(
				response, downloadServletInputStream.getInputStream(),
				downloadServletInputStream.getSize());
		}
	}

	protected void sendFileWithRangeHeader(
			HttpServletRequest request, HttpServletResponse response,
			String fileName, InputStream inputStream, long contentLength,
			String contentType)
		throws IOException {

		if (_log.isDebugEnabled()) {
			_log.debug("Accepting ranges for the file " + fileName);
		}

		response.setHeader(
			HttpHeaders.ACCEPT_RANGES, HttpHeaders.ACCEPT_RANGES_BYTES_VALUE);

		List<Range> ranges = null;

		try {
			ranges = ServletResponseUtil.getRanges(
				request, response, contentLength);
		}
		catch (IOException ioe) {
			if (_log.isErrorEnabled()) {
				_log.error(ioe);
			}

			response.setHeader(
				HttpHeaders.CONTENT_RANGE, "bytes */" + contentLength);

			response.sendError(
				HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE);

			return;
		}

		if ((ranges == null) || ranges.isEmpty()) {
			ServletResponseUtil.sendFile(
				request, response, fileName, inputStream, contentLength,
				contentType);
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Request has range header " +
						request.getHeader(HttpHeaders.RANGE));
			}

			ServletResponseUtil.write(
				request, response, fileName, ranges, inputStream, contentLength,
				contentType);
		}
	}

	protected void sendImage(HttpServletResponse response, long imageId)
		throws Exception {

		User user = UserLocalServiceUtil.fetchUser(imageId);

		if (user != null) {
			imageId = user.getPortraitId();
		}

		Image image = ImageServiceUtil.getImage(imageId);

		String type = image.getType();

		if (!type.equals(ImageConstants.TYPE_NOT_AVAILABLE)) {
			String contentType = MimeTypesUtil.getExtensionContentType(type);

			response.setContentType(contentType);
		}

		ServletResponseUtil.write(response, image.getTextObj());
	}

	protected void sendPatch(
			HttpServletRequest request, HttpServletResponse response,
			long userId, long groupId, String uuid)
		throws Exception {

		long sourceVersionId = ParamUtil.getLong(request, "sourceVersionId", 0);
		long targetVersionId = ParamUtil.getLong(request, "targetVersionId", 0);

		DownloadServletInputStream downloadServletInputStream =
			getPatchDownloadServletInputStream(
				userId, groupId, uuid, sourceVersionId, targetVersionId);

		ServletResponseUtil.write(
			response, downloadServletInputStream.getInputStream(),
			downloadServletInputStream.getSize());
	}

	protected void sendZipFile(
			HttpServletResponse response, long userId,
			JSONArray zipFileIdsJSONArray)
		throws Exception {

		ZipWriter zipWriter = ZipWriterFactoryUtil.getZipWriter();

		JSONObject errorsJSONObject = JSONFactoryUtil.createJSONObject();

		for (int i = 0; i < zipFileIdsJSONArray.length(); i++) {
			JSONObject zipObjectJSONObject = zipFileIdsJSONArray.getJSONObject(
				i);

			long groupId = zipObjectJSONObject.getLong("groupId");
			String zipFileId = zipObjectJSONObject.getString("zipFileId");

			Group group = GroupLocalServiceUtil.fetchGroup(groupId);

			if ((group == null) || !SyncUtil.isSyncEnabled(group)) {
				processException(
					zipFileId, SyncSiteUnavailableException.class.getName(),
					errorsJSONObject);

				continue;
			}

			try {
				String uuid = zipObjectJSONObject.getString("uuid");

				if (zipObjectJSONObject.getBoolean("patch")) {
					long sourceVersionId = zipObjectJSONObject.getLong(
						"sourceVersionId", 0);
					long targetVersionId = zipObjectJSONObject.getLong(
						"targetVersionId", 0);

					DownloadServletInputStream downloadServletInputStream =
						getPatchDownloadServletInputStream(
							userId, groupId, uuid, sourceVersionId,
							targetVersionId);

					zipWriter.addEntry(
						zipFileId, downloadServletInputStream.getInputStream());
				}
				else {
					DownloadServletInputStream downloadServletInputStream =
						getFileDownloadServletInputStream(
							userId, groupId, uuid,
							zipObjectJSONObject.getString("version"),
							zipObjectJSONObject.getLong("versionId"));

					zipWriter.addEntry(
						zipFileId, downloadServletInputStream.getInputStream());
				}
			}
			catch (Exception e) {
				processException(
					zipFileId, e.getClass().getName(), errorsJSONObject);
			}
		}

		zipWriter.addEntry("errors.json", errorsJSONObject.toString());

		File file = zipWriter.getFile();

		ServletResponseUtil.write(
			response, new FileInputStream(file), file.length());
	}

	protected void sendZipFolder(
			HttpServletResponse response, long userId, long repositoryId,
			long folderId)
		throws Exception {

		ZipWriter zipWriter = ZipWriterFactoryUtil.getZipWriter();

		addZipFolderEntry(
			userId, repositoryId, folderId, StringPool.BLANK, zipWriter);

		File file = zipWriter.getFile();

		ServletResponseUtil.write(
			response, new FileInputStream(file), file.length());
	}

	private static final String _ERROR_HEADER = "Sync-Error";

	private static Log _log = LogFactory.getLog(DownloadServlet.class);

}
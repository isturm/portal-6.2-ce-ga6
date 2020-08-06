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

package com.liferay.sync.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.liferay.sync.model.SyncDLFileVersionDiff;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SyncDLFileVersionDiff in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SyncDLFileVersionDiff
 * @generated
 */
public class SyncDLFileVersionDiffCacheModel implements CacheModel<SyncDLFileVersionDiff>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{syncDLFileVersionDiffId=");
		sb.append(syncDLFileVersionDiffId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", sourceFileVersionId=");
		sb.append(sourceFileVersionId);
		sb.append(", targetFileVersionId=");
		sb.append(targetFileVersionId);
		sb.append(", dataFileEntryId=");
		sb.append(dataFileEntryId);
		sb.append(", size=");
		sb.append(size);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append("}");

		return sb.toString();
	}


	public SyncDLFileVersionDiff toEntityModel() {
		SyncDLFileVersionDiffImpl syncDLFileVersionDiffImpl = new SyncDLFileVersionDiffImpl();

		syncDLFileVersionDiffImpl.setSyncDLFileVersionDiffId(syncDLFileVersionDiffId);
		syncDLFileVersionDiffImpl.setFileEntryId(fileEntryId);
		syncDLFileVersionDiffImpl.setSourceFileVersionId(sourceFileVersionId);
		syncDLFileVersionDiffImpl.setTargetFileVersionId(targetFileVersionId);
		syncDLFileVersionDiffImpl.setDataFileEntryId(dataFileEntryId);
		syncDLFileVersionDiffImpl.setSize(size);

		if (expirationDate == Long.MIN_VALUE) {
			syncDLFileVersionDiffImpl.setExpirationDate(null);
		}
		else {
			syncDLFileVersionDiffImpl.setExpirationDate(new Date(expirationDate));
		}

		syncDLFileVersionDiffImpl.resetOriginalValues();

		return syncDLFileVersionDiffImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		syncDLFileVersionDiffId = objectInput.readLong();
		fileEntryId = objectInput.readLong();
		sourceFileVersionId = objectInput.readLong();
		targetFileVersionId = objectInput.readLong();
		dataFileEntryId = objectInput.readLong();
		size = objectInput.readLong();
		expirationDate = objectInput.readLong();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(syncDLFileVersionDiffId);
		objectOutput.writeLong(fileEntryId);
		objectOutput.writeLong(sourceFileVersionId);
		objectOutput.writeLong(targetFileVersionId);
		objectOutput.writeLong(dataFileEntryId);
		objectOutput.writeLong(size);
		objectOutput.writeLong(expirationDate);
	}

	public long syncDLFileVersionDiffId;
	public long fileEntryId;
	public long sourceFileVersionId;
	public long targetFileVersionId;
	public long dataFileEntryId;
	public long size;
	public long expirationDate;
}
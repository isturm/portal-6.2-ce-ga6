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

package com.liferay.marketplace.model;

import com.liferay.marketplace.service.AppLocalServiceUtil;
import com.liferay.marketplace.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Park
 */
public class AppClp extends BaseModelImpl<App> implements App {
	public AppClp() {
	}


	public Class<?> getModelClass() {
		return App.class;
	}


	public String getModelClassName() {
		return App.class.getName();
	}


	public long getPrimaryKey() {
		return _appId;
	}


	public void setPrimaryKey(long primaryKey) {
		setAppId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _appId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appId", getAppId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("remoteAppId", getRemoteAppId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("category", getCategory());
		attributes.put("iconURL", getIconURL());
		attributes.put("version", getVersion());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long appId = (Long)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long remoteAppId = (Long)attributes.get("remoteAppId");

		if (remoteAppId != null) {
			setRemoteAppId(remoteAppId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String iconURL = (String)attributes.get("iconURL");

		if (iconURL != null) {
			setIconURL(iconURL);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}


	public String getUuid() {
		return _uuid;
	}


	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_appRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getAppId() {
		return _appId;
	}


	public void setAppId(long appId) {
		_appId = appId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setAppId", long.class);

				method.invoke(_appRemoteModel, appId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getCompanyId() {
		return _companyId;
	}


	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_appRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getUserId() {
		return _userId;
	}


	public void setUserId(long userId) {
		_userId = userId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_appRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}


	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}


	public String getUserName() {
		return _userName;
	}


	public void setUserName(String userName) {
		_userName = userName;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_appRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public Date getCreateDate() {
		return _createDate;
	}


	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_appRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public Date getModifiedDate() {
		return _modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_appRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getRemoteAppId() {
		return _remoteAppId;
	}


	public void setRemoteAppId(long remoteAppId) {
		_remoteAppId = remoteAppId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setRemoteAppId", long.class);

				method.invoke(_appRemoteModel, remoteAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getTitle() {
		return _title;
	}


	public void setTitle(String title) {
		_title = title;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_appRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getDescription() {
		return _description;
	}


	public void setDescription(String description) {
		_description = description;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_appRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getCategory() {
		return _category;
	}


	public void setCategory(String category) {
		_category = category;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_appRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getIconURL() {
		return _iconURL;
	}


	public void setIconURL(String iconURL) {
		_iconURL = iconURL;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setIconURL", String.class);

				method.invoke(_appRemoteModel, iconURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getVersion() {
		return _version;
	}


	public void setVersion(String version) {
		_version = version;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_appRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public boolean isDownloaded() {
		try {
			String methodName = "isDownloaded";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public java.lang.String getFileDir() {
		try {
			String methodName = "getFileDir";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public java.lang.String getFileName() {
		try {
			String methodName = "getFileName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public boolean isInstalled() {
		try {
			String methodName = "isInstalled";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public java.lang.String[] addContextName(java.lang.String contextName) {
		try {
			String methodName = "addContextName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { contextName };

			java.lang.String[] returnObj = (java.lang.String[])invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public java.lang.String[] getContextNames() {
		try {
			String methodName = "getContextNames";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String[] returnObj = (java.lang.String[])invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public java.lang.String getFilePath() {
		try {
			String methodName = "getFilePath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}


	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				App.class.getName()));
	}

	public BaseModel<?> getAppRemoteModel() {
		return _appRemoteModel;
	}

	public void setAppRemoteModel(BaseModel<?> appRemoteModel) {
		_appRemoteModel = appRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _appRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_appRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}


	public void persist() throws SystemException {
		if (this.isNew()) {
			AppLocalServiceUtil.addApp(this);
		}
		else {
			AppLocalServiceUtil.updateApp(this);
		}
	}


	public App toEscapedModel() {
		return (App)ProxyUtil.newProxyInstance(App.class.getClassLoader(),
			new Class[] { App.class }, new AutoEscapeBeanHandler(this));
	}


	public Object clone() {
		AppClp clone = new AppClp();

		clone.setUuid(getUuid());
		clone.setAppId(getAppId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRemoteAppId(getRemoteAppId());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setCategory(getCategory());
		clone.setIconURL(getIconURL());
		clone.setVersion(getVersion());

		return clone;
	}


	public int compareTo(App app) {
		long primaryKey = app.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppClp)) {
			return false;
		}

		AppClp app = (AppClp)obj;

		long primaryKey = app.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}


	public int hashCode() {
		return (int)getPrimaryKey();
	}


	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", appId=");
		sb.append(getAppId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", remoteAppId=");
		sb.append(getRemoteAppId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", iconURL=");
		sb.append(getIconURL());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.marketplace.model.App");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appId</column-name><column-value><![CDATA[");
		sb.append(getAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteAppId</column-name><column-value><![CDATA[");
		sb.append(getRemoteAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconURL</column-name><column-value><![CDATA[");
		sb.append(getIconURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _appId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _remoteAppId;
	private String _title;
	private String _description;
	private String _category;
	private String _iconURL;
	private String _version;
	private BaseModel<?> _appRemoteModel;
}
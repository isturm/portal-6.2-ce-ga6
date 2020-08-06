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

package com.liferay.sync.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sync.service.ClpSerializer;
import com.liferay.sync.service.SyncDLFileVersionDiffLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDLFileVersionDiffClp extends BaseModelImpl<SyncDLFileVersionDiff>
	implements SyncDLFileVersionDiff {
	public SyncDLFileVersionDiffClp() {
	}


	public Class<?> getModelClass() {
		return SyncDLFileVersionDiff.class;
	}


	public String getModelClassName() {
		return SyncDLFileVersionDiff.class.getName();
	}


	public long getPrimaryKey() {
		return _syncDLFileVersionDiffId;
	}


	public void setPrimaryKey(long primaryKey) {
		setSyncDLFileVersionDiffId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _syncDLFileVersionDiffId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("syncDLFileVersionDiffId", getSyncDLFileVersionDiffId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("sourceFileVersionId", getSourceFileVersionId());
		attributes.put("targetFileVersionId", getTargetFileVersionId());
		attributes.put("dataFileEntryId", getDataFileEntryId());
		attributes.put("size", getSize());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long syncDLFileVersionDiffId = (Long)attributes.get(
				"syncDLFileVersionDiffId");

		if (syncDLFileVersionDiffId != null) {
			setSyncDLFileVersionDiffId(syncDLFileVersionDiffId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long sourceFileVersionId = (Long)attributes.get("sourceFileVersionId");

		if (sourceFileVersionId != null) {
			setSourceFileVersionId(sourceFileVersionId);
		}

		Long targetFileVersionId = (Long)attributes.get("targetFileVersionId");

		if (targetFileVersionId != null) {
			setTargetFileVersionId(targetFileVersionId);
		}

		Long dataFileEntryId = (Long)attributes.get("dataFileEntryId");

		if (dataFileEntryId != null) {
			setDataFileEntryId(dataFileEntryId);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}


	public long getSyncDLFileVersionDiffId() {
		return _syncDLFileVersionDiffId;
	}


	public void setSyncDLFileVersionDiffId(long syncDLFileVersionDiffId) {
		_syncDLFileVersionDiffId = syncDLFileVersionDiffId;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setSyncDLFileVersionDiffId",
						long.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel,
					syncDLFileVersionDiffId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getFileEntryId() {
		return _fileEntryId;
	}


	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getSourceFileVersionId() {
		return _sourceFileVersionId;
	}


	public void setSourceFileVersionId(long sourceFileVersionId) {
		_sourceFileVersionId = sourceFileVersionId;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceFileVersionId",
						long.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel,
					sourceFileVersionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getTargetFileVersionId() {
		return _targetFileVersionId;
	}


	public void setTargetFileVersionId(long targetFileVersionId) {
		_targetFileVersionId = targetFileVersionId;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetFileVersionId",
						long.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel,
					targetFileVersionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getDataFileEntryId() {
		return _dataFileEntryId;
	}


	public void setDataFileEntryId(long dataFileEntryId) {
		_dataFileEntryId = dataFileEntryId;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setDataFileEntryId", long.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel, dataFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getSize() {
		return _size;
	}


	public void setSize(long size) {
		_size = size;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setSize", long.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel, size);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public Date getExpirationDate() {
		return _expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;

		if (_syncDLFileVersionDiffRemoteModel != null) {
			try {
				Class<?> clazz = _syncDLFileVersionDiffRemoteModel.getClass();

				Method method = clazz.getMethod("setExpirationDate", Date.class);

				method.invoke(_syncDLFileVersionDiffRemoteModel, expirationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSyncDLFileVersionDiffRemoteModel() {
		return _syncDLFileVersionDiffRemoteModel;
	}

	public void setSyncDLFileVersionDiffRemoteModel(
		BaseModel<?> syncDLFileVersionDiffRemoteModel) {
		_syncDLFileVersionDiffRemoteModel = syncDLFileVersionDiffRemoteModel;
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

		Class<?> remoteModelClass = _syncDLFileVersionDiffRemoteModel.getClass();

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

		Object returnValue = method.invoke(_syncDLFileVersionDiffRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}


	public void persist() throws SystemException {
		if (this.isNew()) {
			SyncDLFileVersionDiffLocalServiceUtil.addSyncDLFileVersionDiff(this);
		}
		else {
			SyncDLFileVersionDiffLocalServiceUtil.updateSyncDLFileVersionDiff(this);
		}
	}


	public SyncDLFileVersionDiff toEscapedModel() {
		return (SyncDLFileVersionDiff)ProxyUtil.newProxyInstance(SyncDLFileVersionDiff.class.getClassLoader(),
			new Class[] { SyncDLFileVersionDiff.class },
			new AutoEscapeBeanHandler(this));
	}


	public Object clone() {
		SyncDLFileVersionDiffClp clone = new SyncDLFileVersionDiffClp();

		clone.setSyncDLFileVersionDiffId(getSyncDLFileVersionDiffId());
		clone.setFileEntryId(getFileEntryId());
		clone.setSourceFileVersionId(getSourceFileVersionId());
		clone.setTargetFileVersionId(getTargetFileVersionId());
		clone.setDataFileEntryId(getDataFileEntryId());
		clone.setSize(getSize());
		clone.setExpirationDate(getExpirationDate());

		return clone;
	}


	public int compareTo(SyncDLFileVersionDiff syncDLFileVersionDiff) {
		long primaryKey = syncDLFileVersionDiff.getPrimaryKey();

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

		if (!(obj instanceof SyncDLFileVersionDiffClp)) {
			return false;
		}

		SyncDLFileVersionDiffClp syncDLFileVersionDiff = (SyncDLFileVersionDiffClp)obj;

		long primaryKey = syncDLFileVersionDiff.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}


	public int hashCode() {
		return (int)getPrimaryKey();
	}


	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{syncDLFileVersionDiffId=");
		sb.append(getSyncDLFileVersionDiffId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", sourceFileVersionId=");
		sb.append(getSourceFileVersionId());
		sb.append(", targetFileVersionId=");
		sb.append(getTargetFileVersionId());
		sb.append(", dataFileEntryId=");
		sb.append(getDataFileEntryId());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sync.model.SyncDLFileVersionDiff");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>syncDLFileVersionDiffId</column-name><column-value><![CDATA[");
		sb.append(getSyncDLFileVersionDiffId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sourceFileVersionId</column-name><column-value><![CDATA[");
		sb.append(getSourceFileVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetFileVersionId</column-name><column-value><![CDATA[");
		sb.append(getTargetFileVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getDataFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _syncDLFileVersionDiffId;
	private long _fileEntryId;
	private long _sourceFileVersionId;
	private long _targetFileVersionId;
	private long _dataFileEntryId;
	private long _size;
	private Date _expirationDate;
	private BaseModel<?> _syncDLFileVersionDiffRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sync.service.ClpSerializer.class;
}
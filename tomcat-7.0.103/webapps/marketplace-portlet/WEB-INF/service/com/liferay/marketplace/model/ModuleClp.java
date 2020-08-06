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

import com.liferay.marketplace.service.ClpSerializer;
import com.liferay.marketplace.service.ModuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Park
 */
public class ModuleClp extends BaseModelImpl<Module> implements Module {
	public ModuleClp() {
	}


	public Class<?> getModelClass() {
		return Module.class;
	}


	public String getModelClassName() {
		return Module.class.getName();
	}


	public long getPrimaryKey() {
		return _moduleId;
	}


	public void setPrimaryKey(long primaryKey) {
		setModuleId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _moduleId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("moduleId", getModuleId());
		attributes.put("appId", getAppId());
		attributes.put("bundleSymbolicName", getBundleSymbolicName());
		attributes.put("bundleVersion", getBundleVersion());
		attributes.put("contextName", getContextName());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long moduleId = (Long)attributes.get("moduleId");

		if (moduleId != null) {
			setModuleId(moduleId);
		}

		Long appId = (Long)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		String bundleSymbolicName = (String)attributes.get("bundleSymbolicName");

		if (bundleSymbolicName != null) {
			setBundleSymbolicName(bundleSymbolicName);
		}

		String bundleVersion = (String)attributes.get("bundleVersion");

		if (bundleVersion != null) {
			setBundleVersion(bundleVersion);
		}

		String contextName = (String)attributes.get("contextName");

		if (contextName != null) {
			setContextName(contextName);
		}
	}


	public String getUuid() {
		return _uuid;
	}


	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_moduleRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getModuleId() {
		return _moduleId;
	}


	public void setModuleId(long moduleId) {
		_moduleId = moduleId;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleId", long.class);

				method.invoke(_moduleRemoteModel, moduleId);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setAppId", long.class);

				method.invoke(_moduleRemoteModel, appId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getBundleSymbolicName() {
		return _bundleSymbolicName;
	}


	public void setBundleSymbolicName(String bundleSymbolicName) {
		_bundleSymbolicName = bundleSymbolicName;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setBundleSymbolicName",
						String.class);

				method.invoke(_moduleRemoteModel, bundleSymbolicName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getBundleVersion() {
		return _bundleVersion;
	}


	public void setBundleVersion(String bundleVersion) {
		_bundleVersion = bundleVersion;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setBundleVersion", String.class);

				method.invoke(_moduleRemoteModel, bundleVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getContextName() {
		return _contextName;
	}


	public void setContextName(String contextName) {
		_contextName = contextName;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setContextName", String.class);

				method.invoke(_moduleRemoteModel, contextName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getModuleRemoteModel() {
		return _moduleRemoteModel;
	}

	public void setModuleRemoteModel(BaseModel<?> moduleRemoteModel) {
		_moduleRemoteModel = moduleRemoteModel;
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

		Class<?> remoteModelClass = _moduleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_moduleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}


	public void persist() throws SystemException {
		if (this.isNew()) {
			ModuleLocalServiceUtil.addModule(this);
		}
		else {
			ModuleLocalServiceUtil.updateModule(this);
		}
	}


	public Module toEscapedModel() {
		return (Module)ProxyUtil.newProxyInstance(Module.class.getClassLoader(),
			new Class[] { Module.class }, new AutoEscapeBeanHandler(this));
	}


	public Object clone() {
		ModuleClp clone = new ModuleClp();

		clone.setUuid(getUuid());
		clone.setModuleId(getModuleId());
		clone.setAppId(getAppId());
		clone.setBundleSymbolicName(getBundleSymbolicName());
		clone.setBundleVersion(getBundleVersion());
		clone.setContextName(getContextName());

		return clone;
	}


	public int compareTo(Module module) {
		long primaryKey = module.getPrimaryKey();

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

		if (!(obj instanceof ModuleClp)) {
			return false;
		}

		ModuleClp module = (ModuleClp)obj;

		long primaryKey = module.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", moduleId=");
		sb.append(getModuleId());
		sb.append(", appId=");
		sb.append(getAppId());
		sb.append(", bundleSymbolicName=");
		sb.append(getBundleSymbolicName());
		sb.append(", bundleVersion=");
		sb.append(getBundleVersion());
		sb.append(", contextName=");
		sb.append(getContextName());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.marketplace.model.Module");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleId</column-name><column-value><![CDATA[");
		sb.append(getModuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appId</column-name><column-value><![CDATA[");
		sb.append(getAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bundleSymbolicName</column-name><column-value><![CDATA[");
		sb.append(getBundleSymbolicName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bundleVersion</column-name><column-value><![CDATA[");
		sb.append(getBundleVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contextName</column-name><column-value><![CDATA[");
		sb.append(getContextName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _moduleId;
	private long _appId;
	private String _bundleSymbolicName;
	private String _bundleVersion;
	private String _contextName;
	private BaseModel<?> _moduleRemoteModel;
}
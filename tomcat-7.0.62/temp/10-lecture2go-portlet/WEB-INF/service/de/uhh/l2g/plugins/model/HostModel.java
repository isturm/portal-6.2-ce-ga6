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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Host service. Represents a row in the &quot;LG_Host&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.HostModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.HostImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Host
 * @see de.uhh.l2g.plugins.model.impl.HostImpl
 * @see de.uhh.l2g.plugins.model.impl.HostModelImpl
 * @generated
 */
public interface HostModel extends BaseModel<Host> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a host model instance should use the {@link Host} interface instead.
	 */

	/**
	 * Returns the primary key of this host.
	 *
	 * @return the primary key of this host
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this host.
	 *
	 * @param primaryKey the primary key of this host
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the host ID of this host.
	 *
	 * @return the host ID of this host
	 */
	public long getHostId();

	/**
	 * Sets the host ID of this host.
	 *
	 * @param hostId the host ID of this host
	 */
	public void setHostId(long hostId);

	/**
	 * Returns the protocol of this host.
	 *
	 * @return the protocol of this host
	 */
	@AutoEscape
	public String getProtocol();

	/**
	 * Sets the protocol of this host.
	 *
	 * @param protocol the protocol of this host
	 */
	public void setProtocol(String protocol);

	/**
	 * Returns the streamer of this host.
	 *
	 * @return the streamer of this host
	 */
	@AutoEscape
	public String getStreamer();

	/**
	 * Sets the streamer of this host.
	 *
	 * @param streamer the streamer of this host
	 */
	public void setStreamer(String streamer);

	/**
	 * Returns the port of this host.
	 *
	 * @return the port of this host
	 */
	public int getPort();

	/**
	 * Sets the port of this host.
	 *
	 * @param port the port of this host
	 */
	public void setPort(int port);

	/**
	 * Returns the server root of this host.
	 *
	 * @return the server root of this host
	 */
	@AutoEscape
	public String getServerRoot();

	/**
	 * Sets the server root of this host.
	 *
	 * @param serverRoot the server root of this host
	 */
	public void setServerRoot(String serverRoot);

	/**
	 * Returns the name of this host.
	 *
	 * @return the name of this host
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this host.
	 *
	 * @param name the name of this host
	 */
	public void setName(String name);

	/**
	 * Returns the default host of this host.
	 *
	 * @return the default host of this host
	 */
	public int getDefaultHost();

	/**
	 * Sets the default host of this host.
	 *
	 * @param defaultHost the default host of this host
	 */
	public void setDefaultHost(int defaultHost);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Host host);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.model.Host> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.model.Host toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.model.Host toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
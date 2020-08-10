/*******************************************************************************
 * License
 * 
 * The Lecture2Go software is based on the liferay portal 6.2-ga6
 * <http://www.liferay.com> (Copyright notice see below)
 * 
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 * 
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * 
 * Copyright (c) 2013 - present University of Hamburg / Computer and Data Center (RRZ)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * The Liferay Plugins SDK:
 * 
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
 * 
 * Third Party Software
 * 
 * Lecture2Go uses third-party libraries which may be distributed under different licenses 
 * to the above (but are compatible with the used GPL license). Informations about these 
 * licenses and copyright informations are mostly detailed in the library source code or jars themselves. 
 * You must agree to the terms of these licenses, in addition to  the above Lecture2Go source code license, 
 * in order to use this software.
 ******************************************************************************/
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.NoPropertyException;
import de.uhh.l2g.plugins.admin.AdminStreamerManagement;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl;
import de.uhh.l2g.plugins.util.RepositoryManager;

/**
 * The implementation of the host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.uhh.l2g.plugins.service.HostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.HostLocalServiceUtil
 */
public class HostLocalServiceImpl extends HostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.uhh.l2g.plugins.service.HostLocalServiceUtil} to access the host local
	 * service.
	 */

	protected static Log LOG = LogFactoryUtil.getLog(Host.class.getName());
	protected static final String SYS_ROOT = "vh_000";
	protected static final String SYS_SERVER = "localhost";
	protected static final String SYS_PROTOCOL = "http";
	protected static final int SYS_PORT = 80;

	public Host getByInstitution(long institutionId) throws SystemException {
		Host h = null;
		try {
			h = Institution_HostLocalServiceUtil.getByInstitutionId(institutionId);
		} catch (PortalException e) {
			LOG.debug("Can't fetch host by institution id "+institutionId);
		}
		return h;
	}

	public int countAll(){
		int count = 0;
		try {
			count = hostPersistence.countAll();
		} catch (SystemException e) {
			LOG.debug("Can't fetch number of hosts");
		}
		return count;
	}
	
	public List<Host> getAll(){
		List<Host> ret = new ArrayList<Host>(); 
		try {
			ret = hostPersistence.findAll();
		} catch (SystemException e) {
			LOG.debug("Can't fetch list of all hosts");
		}
		return ret;
	}
	
	public List<Host> getAll(int start, int end){
		List<Host> ret = new ArrayList<Host>(); 
		try {
			ret = hostPersistence.findAll(start, end);
		} catch (SystemException e) {
			LOG.debug("Can't fetch list of hosts");
		}
		return ret;
	}
	
	public Host getByHostId(long hostId) throws SystemException {
		return hostPersistence.fetchByPrimaryKey(hostId);
	}
	
	public Host getDefaultHost(){
		Host defaultHost = HostLocalServiceUtil.createHost(0);
		try {
			defaultHost = hostPersistence.findBydefaultHost(0);
		} catch (Exception e) {
			LOG.debug("Can't fetch default host");
		}
		return defaultHost;
	}

	/** Host is locked if it is linked to an institution */
	public int getLockingElements(long hostId) throws SystemException {
		int c = 0;
		try {
			c = Institution_HostLocalServiceUtil.getByHostIdCount(hostId);
		} catch (PortalException e) {
			LOG.debug("Can't fetch locking elements");
		}
		return c;
	}

	protected void validate(String name, String streamer) throws PortalException {
		// only default host db entries name field is allowed to be empty
		if (Validator.isNull(name)) {
			throw new HostNameException();
		}

		if (Validator.isNull(streamer) || !Validator.isDomain(streamer) || !Validator.isHostName(streamer)) {
			throw new HostStreamerException();
		}
	}

	/**
	 * Special handling for default entries (no update)
	 * 
	 */
	public Host addDefaultHost(ServiceContext serviceContext) throws SystemException, PortalException {
		long hostId = counterLocalService.increment(Host.class.getName());
		Host defaultHost = hostPersistence.create(hostId);

		LOG.debug("Writing Host");
		defaultHost.setName(AdminStreamerManagement.DEFAULT_STREAMER);

		// Load from Portal Properties
		String streamer = GetterUtil.getString(PropsUtil.get("lecture2go.default.streamingHost"));
		String protocol = GetterUtil.getString(PropsUtil.get("lecture2go.default.streamingProtocol"));
		String serverRoot = GetterUtil.getString(PropsUtil.get("lecture2go.default.serverRoot"));
		int port = Integer.valueOf(GetterUtil.getInteger(PropsUtil.get("lecture2go.default.streamingPort")));

		if (streamer.isEmpty()) {
			streamer = RepositoryManager.SYS_SERVER;
			LOG.error("Portal property lecture2go.default.streamingHost not set. Using default!");
		}
		if (protocol.isEmpty()) {
			protocol = RepositoryManager.SYS_PROTOCOL;
			LOG.error("Portal property lecture2go.default.streamingProtocol not set. Using default!");
		}
		if (serverRoot.isEmpty()) {
			serverRoot = RepositoryManager.SYS_ROOT;
			LOG.error("Portal property lecture2go.default.serverRoot not set. Using default!");
		}
		if (port == 0) {
			port = RepositoryManager.SYS_PORT;
			LOG.error("Portal property lecture2go.default.streamingPort not set. Using default!");
		}
		defaultHost.setStreamer(streamer);
		defaultHost.setProtocol(protocol);
		defaultHost.setServerRoot(serverRoot);
		defaultHost.setPort(port);
		defaultHost.setDefaultHost(1);

		defaultHost.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(defaultHost);

		String repository = GetterUtil.getString(PropsUtil.get("lecture2go.media.repository"));
		if (repository.isEmpty()) {
			LOG.error("Portal property lecture2go.media.repository not set. This path must be specified set before installation!");
			throw new NoPropertyException();
		}
		try {
			RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository") + "/" + defaultHost.getServerRoot());
		} catch (IOException e) {
			LOG.error("Folder creation failed!", e);
		}
		return defaultHost;
	}

	public Host addHost(String name, String streamLocation, String protocol, int port) throws SystemException, PortalException {
		long hostId = counterLocalService.increment(Host.class.getName());
		Host host = hostPersistence.create(hostId);
		host.setName(RepositoryManager.prepareServerRoot(hostId));
		host.setStreamer(streamLocation);
		host.setProtocol(protocol);
		host.setServerRoot(RepositoryManager.prepareServerRoot(hostId));
		host.setPort(port);
		hostPersistence.update(host);

		// Create Directory
		try {
			RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return host;
	}

	public Host updateHost(long hostId, String name, String streamLocation, String protocol, int port) throws SystemException, PortalException {
		validate(name, streamLocation);
		Host host = getHost(hostId);
		host.setName(name);
		// host.setStreamingServerTemplateId(streamingServerTemplateId);
		host.setStreamer(streamLocation);
		host.setProtocol(protocol);
		// Server Root will be constant over all changes
		// host.setServerRoot(serverRoot);
		host.setPort(port);
		hostPersistence.update(host);
		return host;
	}

	/**
	 * Removes database record of Host
	 * 
	 * This will not remove Folder on Filesystem, Folder will not be reused
	 * 
	 */
	public Host deleteHost(long hostId, ServiceContext serviceContext) throws PortalException, SystemException {
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		Host host = getHost(hostId);
		int l = getLockingElements(hostId);

		if (l < 1) {
			resourceLocalService.deleteResource(companyId, Host.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, hostId);
			host = deleteHost(hostId);
			//delete directory
			//String hostDir = PropsUtil.get("lecture2go.media.repository") +"/" +host.getServerRoot(); 
			//File d = new File(hostDir);
			//d.delete();
		} else {
			String message = LanguageUtil.format(serviceContext.getLocale(), "There are {0} objects still refering to this institution", l);
			SessionMessages.add(serviceContext.getRequest(), "deletion-locked", message);
			System.out.println("Could not delete Host because it is still used by " + l + " Institutions");
		}
		return host;
	}

	public long updateCounter() throws SystemException, PortalException {
		// current counter
		Counter counter = CounterLocalServiceUtil.getCounter(Host.class.getName());
		LOG.debug(counter.getCurrentId());
		// check Host Count (if 1 it is supposed to be default host)
		if (GetterUtil.getString(PropsUtil.get("counter.increment")).isEmpty()) {
			LOG.info("It's strongly suggested to set portal property: counter.increment." + Host.class.getName() + "=1");
		}
		int count = HostLocalServiceUtil.getHostsCount();
		LOG.debug(count);
		long newHostId = 0; // Reset if table is empty
		long hostId = 0; // the actual Id value

		if (count > 0) { // our db is filled... with something at least
			// Retrieve actual table data
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Host.class, classLoader).addOrder(OrderFactoryUtil.desc("hostId"));
			query.setLimit(0, 1);
			List<Host> hosts = HostLocalServiceUtil.dynamicQuery(query);
			if (hosts.size() > 0) hostId = hosts.get(0).getHostId(); // current maximum Id
		}
		
		// Check back with real directory (there might be old directories, our
		// DB does not know or remember)
		newHostId = java.lang.Math.max(RepositoryManager.getMaximumRealServerRootId(), hostId);
		LOG.debug(newHostId);
		
		// Increment Counter if assynchrone with estimated value or data reseted
		if (counter.getCurrentId() < newHostId || newHostId == 0) {
			counter.setCurrentId(newHostId);
			CounterLocalServiceUtil.updateCounter(counter);
		}

		return counter.getCurrentId();
	}
}

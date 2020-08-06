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

package com.liferay.sync.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SyncPreferencesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SyncPreferencesLocalService
 * @generated
 */
public class SyncPreferencesLocalServiceWrapper
	implements SyncPreferencesLocalService,
		ServiceWrapper<SyncPreferencesLocalService> {
	public SyncPreferencesLocalServiceWrapper(
		SyncPreferencesLocalService syncPreferencesLocalService) {
		_syncPreferencesLocalService = syncPreferencesLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _syncPreferencesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_syncPreferencesLocalService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _syncPreferencesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}


	public com.liferay.oauth.model.OAuthApplication enableOAuth(
		long companyId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _syncPreferencesLocalService.enableOAuth(companyId,
			serviceContext);
	}


	public javax.portlet.PortletPreferences getPortletPreferences(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _syncPreferencesLocalService.getPortletPreferences(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SyncPreferencesLocalService getWrappedSyncPreferencesLocalService() {
		return _syncPreferencesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSyncPreferencesLocalService(
		SyncPreferencesLocalService syncPreferencesLocalService) {
		_syncPreferencesLocalService = syncPreferencesLocalService;
	}


	public SyncPreferencesLocalService getWrappedService() {
		return _syncPreferencesLocalService;
	}


	public void setWrappedService(
		SyncPreferencesLocalService syncPreferencesLocalService) {
		_syncPreferencesLocalService = syncPreferencesLocalService;
	}

	private SyncPreferencesLocalService _syncPreferencesLocalService;
}
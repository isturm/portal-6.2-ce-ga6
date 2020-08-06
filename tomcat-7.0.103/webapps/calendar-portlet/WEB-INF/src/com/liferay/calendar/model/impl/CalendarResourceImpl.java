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

package com.liferay.calendar.model.impl;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.List;
import java.util.TimeZone;

/**
 * @author Eduardo Lundgren
 * @author Marcellus Tavares
 */
public class CalendarResourceImpl extends CalendarResourceBaseImpl {


	public List<Calendar> getCalendars() throws SystemException {
		List<Calendar> calendars =
			CalendarLocalServiceUtil.getCalendarResourceCalendars(
				getGroupId(), getCalendarResourceId());

		return calendars;
	}


	public Calendar getDefaultCalendar() throws SystemException {
		List<Calendar> calendars =
			CalendarLocalServiceUtil.getCalendarResourceCalendars(
				getGroupId(), getCalendarResourceId(), true);

		if (!calendars.isEmpty()) {
			return calendars.get(0);
		}

		return null;
	}


	public long getDefaultCalendarId() throws SystemException {
		Calendar calendar = getDefaultCalendar();

		if (calendar != null) {
			return calendar.getCalendarId();
		}

		return 0;
	}


	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CalendarResource.class.getName()));
	}


	public TimeZone getTimeZone() throws PortalException, SystemException {
		if (isUser()) {
			User user = UserLocalServiceUtil.getUser(getClassPK());

			return user.getTimeZone();
		}

		return TimeZoneUtil.getDefault();
	}


	public String getTimeZoneId() throws PortalException, SystemException {
		TimeZone timeZone = getTimeZone();

		return timeZone.getID();
	}


	public boolean isGroup() {
		long groupClassNameId = PortalUtil.getClassNameId(Group.class);

		if (groupClassNameId == getClassNameId()) {
			return true;
		}

		return false;
	}


	public boolean isUser() {
		long userClassNameId = PortalUtil.getClassNameId(User.class);

		if (userClassNameId == getClassNameId()) {
			return true;
		}

		return false;
	}

}
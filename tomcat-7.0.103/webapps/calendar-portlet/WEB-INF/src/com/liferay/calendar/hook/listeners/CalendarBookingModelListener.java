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

package com.liferay.calendar.hook.listeners;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;

/**
 * @author Adam Brandizzi
 */
public class CalendarBookingModelListener
	extends BaseModelListener<CalendarBooking> {


	public void onAfterRemove(CalendarBooking calendarBooking)
		throws ModelListenerException {

		try {
			CalEvent calEvent =
				CalEventLocalServiceUtil.fetchCalEventByUuidAndGroupId(
					calendarBooking.getUuid(), calendarBooking.getGroupId());

			if (calEvent != null) {
				CalEventLocalServiceUtil.deleteCalEvent(calEvent);
			}
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

}
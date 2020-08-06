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

package com.liferay.calendar.hook.upgrade.v1_0_0;

import com.liferay.calendar.hook.upgrade.v1_0_0.util.CalendarBookingTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.SQLException;

/**
 * @author Jenny Chen
 */
public class UpgradeCalendarBooking extends UpgradeProcess {


	protected void doUpgrade() throws Exception {
		try {
			runSQL("alter_column_type CalendarBooking description TEXT null");
		}
		catch (SQLException sqle) {
			upgradeTable(
				CalendarBookingTable.TABLE_NAME,
				CalendarBookingTable.TABLE_COLUMNS,
				CalendarBookingTable.TABLE_SQL_CREATE,
				CalendarBookingTable.TABLE_SQL_ADD_INDEXES);
		}
	}

}
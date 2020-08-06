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

package com.liferay.sync.hook.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeException;

/**
 * @author Shinn Lok
 */
public abstract class UpgradeProcess
	extends com.liferay.portal.kernel.upgrade.UpgradeProcess {


	public void upgrade() throws UpgradeException {
		try {

			// SYNC-1453

			if (!tableHasData("SyncDLObject")) {
				return;
			}

			super.upgrade();
		}
		catch (Exception e) {
			throw new UpgradeException(e);
		}
	}

}
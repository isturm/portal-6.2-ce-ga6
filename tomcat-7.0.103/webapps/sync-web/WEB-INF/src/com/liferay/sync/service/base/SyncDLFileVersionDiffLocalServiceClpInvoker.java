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

package com.liferay.sync.service.base;

import com.liferay.sync.service.SyncDLFileVersionDiffLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SyncDLFileVersionDiffLocalServiceClpInvoker {
	public SyncDLFileVersionDiffLocalServiceClpInvoker() {
		_methodName0 = "addSyncDLFileVersionDiff";

		_methodParameterTypes0 = new String[] {
				"com.liferay.sync.model.SyncDLFileVersionDiff"
			};

		_methodName1 = "createSyncDLFileVersionDiff";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSyncDLFileVersionDiff";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSyncDLFileVersionDiff";

		_methodParameterTypes3 = new String[] {
				"com.liferay.sync.model.SyncDLFileVersionDiff"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSyncDLFileVersionDiff";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSyncDLFileVersionDiff";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSyncDLFileVersionDiffs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSyncDLFileVersionDiffsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSyncDLFileVersionDiff";

		_methodParameterTypes15 = new String[] {
				"com.liferay.sync.model.SyncDLFileVersionDiff"
			};

		_methodName58 = "getBeanIdentifier";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "setBeanIdentifier";

		_methodParameterTypes59 = new String[] { "java.lang.String" };

		_methodName64 = "addSyncDLFileVersionDiff";

		_methodParameterTypes64 = new String[] {
				"long", "long", "long", "java.io.File"
			};

		_methodName65 = "deleteExpiredSyncDLFileVersionDiffs";

		_methodParameterTypes65 = new String[] {  };

		_methodName66 = "deleteSyncDLFileVersionDiff";

		_methodParameterTypes66 = new String[] {
				"com.liferay.sync.model.SyncDLFileVersionDiff"
			};

		_methodName67 = "deleteSyncDLFileVersionDiffs";

		_methodParameterTypes67 = new String[] { "long" };

		_methodName68 = "fetchSyncDLFileVersionDiff";

		_methodParameterTypes68 = new String[] { "long", "long", "long" };

		_methodName69 = "refreshExpirationDate";

		_methodParameterTypes69 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.addSyncDLFileVersionDiff((com.liferay.sync.model.SyncDLFileVersionDiff)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.createSyncDLFileVersionDiff(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.deleteSyncDLFileVersionDiff(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.deleteSyncDLFileVersionDiff((com.liferay.sync.model.SyncDLFileVersionDiff)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.fetchSyncDLFileVersionDiff(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.getSyncDLFileVersionDiff(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.getSyncDLFileVersionDiffs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.getSyncDLFileVersionDiffsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.updateSyncDLFileVersionDiff((com.liferay.sync.model.SyncDLFileVersionDiff)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			SyncDLFileVersionDiffLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.addSyncDLFileVersionDiff(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.io.File)arguments[3]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			SyncDLFileVersionDiffLocalServiceUtil.deleteExpiredSyncDLFileVersionDiffs();

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.deleteSyncDLFileVersionDiff((com.liferay.sync.model.SyncDLFileVersionDiff)arguments[0]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			SyncDLFileVersionDiffLocalServiceUtil.deleteSyncDLFileVersionDiffs(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return SyncDLFileVersionDiffLocalServiceUtil.fetchSyncDLFileVersionDiff(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			SyncDLFileVersionDiffLocalServiceUtil.refreshExpirationDate(((Long)arguments[0]).longValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
}
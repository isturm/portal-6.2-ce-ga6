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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

/**
 * @author Iavor Sturm
 * @generated
 */
public abstract class Video_LectureseriesActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public Video_LectureseriesActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(Video_LectureseriesLocalServiceUtil.getService());
		setClass(Video_Lectureseries.class);

		setClassLoader(de.uhh.l2g.plugins.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("videoLectureseriesId");
	}
}
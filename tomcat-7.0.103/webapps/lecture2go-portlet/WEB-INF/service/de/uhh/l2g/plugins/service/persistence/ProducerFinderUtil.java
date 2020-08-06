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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Iavor Sturm
 */
public class ProducerFinderUtil {
	public static java.util.List<java.lang.Long> findProducerIds(
		java.lang.Long lectureseriesId, int begin, int end) {
		return getFinder().findProducerIds(lectureseriesId, begin, end);
	}

	public static ProducerFinder getFinder() {
		if (_finder == null) {
			_finder = (ProducerFinder)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					ProducerFinder.class.getName());

			ReferenceRegistry.registerReference(ProducerFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ProducerFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ProducerFinderUtil.class, "_finder");
	}

	private static ProducerFinder _finder;
}
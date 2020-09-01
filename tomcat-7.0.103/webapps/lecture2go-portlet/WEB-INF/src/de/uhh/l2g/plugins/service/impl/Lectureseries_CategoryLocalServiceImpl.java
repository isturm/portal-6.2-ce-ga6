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

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Category;
import de.uhh.l2g.plugins.service.base.Lectureseries_CategoryLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.Lectureseries_CategoryUtil;

/**
 * The implementation of the lectureseries_ category local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Lectureseries_CategoryLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil
 */
public class Lectureseries_CategoryLocalServiceImpl
	extends Lectureseries_CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil} to access the lectureseries_ category local service.
	 */
	protected static Log LOG = LogFactoryUtil.getLog(Lectureseries_Category.class.getName());

	public Lectureseries_Category addLectureseries_Category(Lectureseries_Category lectureseries_Category){
		Long id;
		try {
			id = counterLocalService.increment(Lectureseries_Category.class.getName());
			lectureseries_Category.setPrimaryKey(id);
			super.addLectureseries_Category(lectureseries_Category);
		} catch (SystemException e) {
			LOG.error("can't add new lectures_categorei with id " + lectureseries_Category.getLectureseriesCategoryId() + "!");
		}
		return lectureseries_Category;
	}
	
	public void updateCategoryByLectureseriesAndCategory(Long lectureseriesId, Long categoryId, Long newCategoryId){
		List<Lectureseries_Category> lca = new ArrayList<Lectureseries_Category>();
		try {
			lca = lectureseries_CategoryPersistence.findByCategoryLectureseries(categoryId, lectureseriesId);
			ListIterator<Lectureseries_Category> lci = lca.listIterator();
			while(lci.hasNext()){
				//new object
				Lectureseries_Category nlc = lci.next();
				nlc.setCategoryId(newCategoryId);
				lectureseries_CategoryPersistence.update(nlc);
			}
		} catch (SystemException e) {}
	}
	
	public boolean removeByLectureseriesId(Long lectureseriesId) {
		boolean ret = false;
		try {
			Lectureseries_CategoryUtil.removeByLectureseries(lectureseriesId);
		} catch (SystemException e) {
			ret = true;
			//e.printStackTrace();
		}
		return ret;
	}	
	
}
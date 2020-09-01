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

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.Video_InstitutionLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.Video_InstitutionUtil;

/**
 * The implementation of the video_ institution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Video_InstitutionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Video_InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil
 */
public class Video_InstitutionLocalServiceImpl
	extends Video_InstitutionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil} to access the video_ institution local service.
	 */
	
	protected static Log LOG = LogFactoryUtil.getLog(Video_Institution.class.getName());

	public Video_Institution addVideo_Institution(Video_Institution object){
		Long id;
		try {
			id = counterLocalService.increment(Video_Institution.class.getName());
			object.setPrimaryKey(id);
			super.addVideo_Institution(object);
		} catch (Exception e) {
			LOG.error("can't add new object with id " + object.getPrimaryKey() + "!");
		}
		return object;
	}
	
	public boolean removeByVideoId(Long videoId) {
		boolean ret = false;
		try {
			Video_InstitutionUtil.removeByVideo(videoId);
		} catch (SystemException e) {
			ret = true;
			//e.printStackTrace();
		}
		return ret;
	}

	public boolean removeByInstitutionId(Long institutionId) {
		boolean ret = false;
		try {
			Video_InstitutionUtil.removeByInstitution(institutionId);
		} catch (SystemException e) {
			ret = true;
			//e.printStackTrace();
		}
		return ret;
	}
	
	public List<Video_Institution> getByVideo(Long videoId){
		List<Video_Institution> vi = new ArrayList<Video_Institution>();
		try {
			vi = video_InstitutionPersistence.findByVideo(videoId);
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		return vi;
	}

	public List<Video_Institution> getByInstitution(Long institutionId){
		List<Video_Institution> vi = new ArrayList<Video_Institution>();
		try {
			vi = video_InstitutionPersistence.findByInstitution(institutionId);
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		return vi;
	}
	
	public List<Video_Institution> getByVideoAndInstitution(Long videoId, Long institutionId){
		List<Video_Institution> vi = new ArrayList<Video_Institution>();
		try {
			vi = video_InstitutionPersistence.findByVideoInstitution(videoId, institutionId);
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		return vi;
	}
}
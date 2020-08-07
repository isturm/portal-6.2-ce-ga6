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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.ProducerLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.ProducerFinderUtil;

/**
 * The implementation of the producer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.ProducerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.ProducerLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.ProducerLocalServiceUtil
 */
public class ProducerLocalServiceImpl extends ProducerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.ProducerLocalServiceUtil} to access the producer local service.
	 */	
	
	private List<Producer> fillProps(List<Producer> pl) throws SystemException{
		Iterator<Producer> it = pl.iterator();
		List<Producer> prodL = new  ArrayList<Producer>();
		while (it.hasNext()){
			Producer p = it.next();
			User u;
			try {
				u = UserLocalServiceUtil.getUser(p.getProducerId());
				p.setLastName(u.getLastName());
				p.setFirstName(u.getFirstName());
				p.setEmailAddress(u.getEmailAddress());
				p.setLastLoginDate(u.getLastLoginDate());
				prodL.add(p);
			} catch (PortalException e) {
				//e.printStackTrace();
			}
		}
		
		// Sorting
		Collections.sort(prodL, new Comparator<Producer>() {
				@Override
				public int compare(Producer p1, Producer p2) {
					return  p1.getLastName().compareTo(p2.getLastName());
				}
		    });
		return prodL;
	}
	
	
	public List<Producer> getProducersByInstitutionId(long institutionId) throws SystemException{
		List<Producer> prods = producerPersistence.findByInstitution(institutionId);
		return fillProps(prods);
	}
	
	public List<Producer> getProducersByHostId(long hostId) throws SystemException{
		List<Producer> prods = producerPersistence.findByHost(hostId);
		return fillProps(prods);
	}
	
	public int getProducersByHostIdCount(long hostId) throws SystemException{
		int prods = producerPersistence.countByHost(hostId);
		return prods;
	}
	
	public Producer getById(long producerId) throws SystemException {
		return producerPersistence.fetchByPrimaryKey(producerId);
	}
	
	public Institution getInstitutionByProducer(long producerId) throws SystemException {
		return institutionPersistence.fetchByPrimaryKey(getById(producerId).getInstitutionId());
	}


	public List<Producer> getAllProducers(int begin, int end) throws SystemException{
		List<Producer> prods = ProducerLocalServiceUtil.getProducers(begin, end);
		prods = fillProps(prods);
		
		/* the producers-list is sorted here and not through the database because we do not have the 
		 * user information in the producer data sets and a JOIN seems too complicated */
		List<Producer> producers = ListUtil.sort(prods, new Comparator<Producer>() {
			@Override
			public int compare(Producer p1, Producer p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		return producers;
	}

	public Producer getProdUcer(Long producerId) throws SystemException, PortalException{
		Producer p = ProducerLocalServiceUtil.getProducer(producerId);
		User u = UserLocalServiceUtil.getUser(producerId);
		p.setFirstName(u.getFirstName());
		p.setLastName(u.getLastName());
		p.setLastLoginDate(u.getLastLoginDate());
		p.setEmailAddress(u.getEmailAddress());
		p.setHomeDir(PropsUtil.get("lecture2go.media.repository")+"/"+HostLocalServiceUtil.getByHostId(p.getHostId()).getServerRoot()+"/"+p.getHomeDir());
		return p;
	}
	
	public List<Long> getAllProducerIds(Long lectureseriesId)throws SystemException{
		List<Long> pIds = ProducerFinderUtil.findProducerIds(lectureseriesId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		return pIds;
	}

	public List<Long> getProducerIds(Long lectureseriesId, int begin, int end)throws SystemException{
		List<Long> pIds = ProducerFinderUtil.findProducerIds(lectureseriesId, begin, end);
		return pIds;
	}
	
}
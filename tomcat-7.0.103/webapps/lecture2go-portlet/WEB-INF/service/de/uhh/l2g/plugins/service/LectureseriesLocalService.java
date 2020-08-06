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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Lectureseries. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see LectureseriesLocalServiceUtil
 * @see de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LectureseriesLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LectureseriesLocalServiceUtil} to access the lectureseries local service. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the lectureseries to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public de.uhh.l2g.plugins.model.Lectureseries addLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	*
	* @param lectureseriesId the primary key for the new lectureseries
	* @return the new lectureseries
	*/
	public de.uhh.l2g.plugins.model.Lectureseries createLectureseries(
		long lectureseriesId);

	/**
	* Deletes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries that was removed
	* @throws PortalException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the lectureseries from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public de.uhh.l2g.plugins.model.Lectureseries fetchLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries with the primary key.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries
	* @throws PortalException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public de.uhh.l2g.plugins.model.Lectureseries getLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLectureserieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses.
	*
	* @return the number of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLectureseriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public de.uhh.l2g.plugins.model.Lectureseries updateLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getFilteredByApprovedSemesterFacultyProducer(
		java.lang.Integer approved, java.lang.Long semester,
		java.lang.Long facultyId, java.lang.Long producerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<de.uhh.l2g.plugins.model.Term, java.util.List<de.uhh.l2g.plugins.model.Lectureseries>> getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(
		java.lang.Integer approved, java.lang.Long semester,
		java.lang.Long facultyId, java.lang.Long producerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllLectureseriesWhithOpenaccessVideos();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllLectureseriesWhithPassword();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllForVideo(
		de.uhh.l2g.plugins.model.Video video);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByTerm(
		java.lang.Long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByLatestVideoId(
		java.lang.Long latestVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateOpenAccess(de.uhh.l2g.plugins.model.Video video,
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updatePreviewVideoOpenAccess(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateUploadLatestOpenAccessVideoAndGenerationDate()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateUploadAndGenerationDate(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateCategoryForLectureseries(java.lang.Long lectureseriesId,
		java.lang.Long newCategoryId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
		java.lang.Long institutionId, java.lang.Long parentInstitutionId,
		java.lang.Long termId, java.lang.Long categoryId,
		java.lang.Long creatorId, java.lang.String searchQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLatest(
		int limit);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public de.uhh.l2g.plugins.model.Lectureseries getByUSID(
		java.lang.String usid);
}
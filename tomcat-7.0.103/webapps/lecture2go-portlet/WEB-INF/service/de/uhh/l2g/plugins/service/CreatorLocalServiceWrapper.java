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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CreatorLocalService}.
 *
 * @author Iavor Sturm
 * @see CreatorLocalService
 * @generated
 */
public class CreatorLocalServiceWrapper implements CreatorLocalService,
	ServiceWrapper<CreatorLocalService> {
	public CreatorLocalServiceWrapper(CreatorLocalService creatorLocalService) {
		_creatorLocalService = creatorLocalService;
	}

	/**
	* Adds the creator to the database. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Creator addCreator(
		de.uhh.l2g.plugins.model.Creator creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.addCreator(creator);
	}

	/**
	* Creates a new creator with the primary key. Does not add the creator to the database.
	*
	* @param creatorId the primary key for the new creator
	* @return the new creator
	*/
	@Override
	public de.uhh.l2g.plugins.model.Creator createCreator(long creatorId) {
		return _creatorLocalService.createCreator(creatorId);
	}

	/**
	* Deletes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creatorId the primary key of the creator
	* @return the creator that was removed
	* @throws PortalException if a creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Creator deleteCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.deleteCreator(creatorId);
	}

	/**
	* Deletes the creator from the database. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Creator deleteCreator(
		de.uhh.l2g.plugins.model.Creator creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.deleteCreator(creator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creatorLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Creator fetchCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.fetchCreator(creatorId);
	}

	/**
	* Returns the creator with the primary key.
	*
	* @param creatorId the primary key of the creator
	* @return the creator
	* @throws PortalException if a creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Creator getCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getCreator(creatorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of creators
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreators(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getCreators(start, end);
	}

	/**
	* Returns the number of creators.
	*
	* @return the number of creators
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCreatorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getCreatorsCount();
	}

	/**
	* Updates the creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Creator updateCreator(
		de.uhh.l2g.plugins.model.Creator creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.updateCreator(creator);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _creatorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_creatorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _creatorLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getAllCreators()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getAllCreators();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return _creatorLocalService.getCreatorsByLectureseriesId(lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
		java.lang.Long lectureseriesId) {
		return _creatorLocalService.getCreatorsByLectureseriesIdForOpenAccessVideosOnly(lectureseriesId);
	}

	@Override
	public java.lang.String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
		java.lang.Long lectureseriesId, int maxCreators) {
		return _creatorLocalService.getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(lectureseriesId,
			maxCreators);
	}

	@Override
	public java.lang.String getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
		java.lang.Long lectureseriesId, int maxCreators) {
		return _creatorLocalService.getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(lectureseriesId,
			maxCreators);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByVideoId(
		java.lang.Long videoId) {
		return _creatorLocalService.getCreatorsByVideoId(videoId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsForLectureseriesOverTheAssigenedVideos(
		java.lang.Long lectureseriesId) {
		return _creatorLocalService.getCreatorsForLectureseriesOverTheAssigenedVideos(lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lectureseriesId);
	}

	@Override
	public void updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId() {
		_creatorLocalService.updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId();
	}

	@Override
	public java.lang.String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
		java.lang.Long videoId, int maxCreators) {
		return _creatorLocalService.getCommaSeparatedCreatorsByVideoIdAndMaxCreators(videoId,
			maxCreators);
	}

	@Override
	public java.lang.String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
		java.lang.Long videoId, int maxCreators) {
		return _creatorLocalService.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(videoId,
			maxCreators);
	}

	@Override
	public org.json.JSONArray getJSONCreatorsByVideoId(java.lang.Long videoId) {
		return _creatorLocalService.getJSONCreatorsByVideoId(videoId);
	}

	@Override
	public org.json.JSONArray getJSONCreatorsByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return _creatorLocalService.getJSONCreatorsByLectureseriesId(lectureseriesId);
	}

	@Override
	public org.json.JSONArray getJSONCreator(java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getJSONCreator(creatorId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getByFullName(
		java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creatorLocalService.getByFullName(fullName);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsFromLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds) {
		return _creatorLocalService.getCreatorsFromLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds);
	}

	@Override
	public void deleteById(java.lang.Long id)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		_creatorLocalService.deleteById(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CreatorLocalService getWrappedCreatorLocalService() {
		return _creatorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCreatorLocalService(
		CreatorLocalService creatorLocalService) {
		_creatorLocalService = creatorLocalService;
	}

	@Override
	public CreatorLocalService getWrappedService() {
		return _creatorLocalService;
	}

	@Override
	public void setWrappedService(CreatorLocalService creatorLocalService) {
		_creatorLocalService = creatorLocalService;
	}

	private CreatorLocalService _creatorLocalService;
}
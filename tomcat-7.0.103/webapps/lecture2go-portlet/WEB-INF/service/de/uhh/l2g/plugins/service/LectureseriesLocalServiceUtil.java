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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Lectureseries. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see LectureseriesLocalService
 * @see de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl
 * @generated
 */
public class LectureseriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lectureseries to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries addLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLectureseries(lectureseries);
	}

	/**
	* Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	*
	* @param lectureseriesId the primary key for the new lectureseries
	* @return the new lectureseries
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries createLectureseries(
		long lectureseriesId) {
		return getService().createLectureseries(lectureseriesId);
	}

	/**
	* Deletes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries that was removed
	* @throws PortalException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLectureseries(lectureseriesId);
	}

	/**
	* Deletes the lectureseries from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLectureseries(lectureseries);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries fetchLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLectureseries(lectureseriesId);
	}

	/**
	* Returns the lectureseries with the primary key.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries
	* @throws PortalException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries getLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLectureseries(lectureseriesId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLectureserieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLectureserieses(start, end);
	}

	/**
	* Returns the number of lectureserieses.
	*
	* @return the number of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLectureseriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLectureseriesesCount();
	}

	/**
	* Updates the lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries updateLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLectureseries(lectureseries);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getFilteredByApprovedSemesterFacultyProducer(
		java.lang.Integer approved, java.lang.Long semester,
		java.lang.Long facultyId, java.lang.Long producerId) {
		return getService()
				   .getFilteredByApprovedSemesterFacultyProducer(approved,
			semester, facultyId, producerId);
	}

	public static java.util.Map<de.uhh.l2g.plugins.model.Term, java.util.List<de.uhh.l2g.plugins.model.Lectureseries>> getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(
		java.lang.Integer approved, java.lang.Long semester,
		java.lang.Long facultyId, java.lang.Long producerId) {
		return getService()
				   .getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(approved,
			semester, facultyId, producerId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllLectureseriesWhithOpenaccessVideos() {
		return getService().getAllLectureseriesWhithOpenaccessVideos();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllLectureseriesWhithPassword() {
		return getService().getAllLectureseriesWhithPassword();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllForVideo(
		de.uhh.l2g.plugins.model.Video video) {
		return getService().getAllForVideo(video);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByTerm(
		java.lang.Long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByTerm(termId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByLatestVideoId(
		java.lang.Long latestVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByLatestVideoId(latestVideoId);
	}

	public static void updateOpenAccess(de.uhh.l2g.plugins.model.Video video,
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateOpenAccess(video, lectureseries);
	}

	public static void updatePreviewVideoOpenAccess(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updatePreviewVideoOpenAccess(lectureseries);
	}

	public static void updateUploadLatestOpenAccessVideoAndGenerationDate()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateUploadLatestOpenAccessVideoAndGenerationDate();
	}

	public static void updateUploadAndGenerationDate(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateUploadAndGenerationDate(lectureseries);
	}

	public static void updateCategoryForLectureseries(
		java.lang.Long lectureseriesId, java.lang.Long newCategoryId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateCategoryForLectureseries(lectureseriesId, newCategoryId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
		java.lang.Long institutionId, java.lang.Long parentInstitutionId,
		java.lang.Long termId, java.lang.Long categoryId,
		java.lang.Long creatorId, java.lang.String searchQuery) {
		return getService()
				   .getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId,
			parentInstitutionId, termId, categoryId, creatorId, searchQuery);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLatest(
		int limit) {
		return getService().getLatest(limit);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries getByUSID(
		java.lang.String usid) {
		return getService().getByUSID(usid);
	}

	public static void clearService() {
		_service = null;
	}

	public static LectureseriesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LectureseriesLocalService.class.getName());

			if (invokableLocalService instanceof LectureseriesLocalService) {
				_service = (LectureseriesLocalService)invokableLocalService;
			}
			else {
				_service = new LectureseriesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LectureseriesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LectureseriesLocalService service) {
	}

	private static LectureseriesLocalService _service;
}
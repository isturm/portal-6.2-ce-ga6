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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.model.Video;

import java.util.List;

/**
 * The persistence utility for the video service. This utility wraps {@link VideoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoPersistence
 * @see VideoPersistenceImpl
 * @generated
 */
public class VideoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Video video) {
		getPersistence().clearCache(video);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Video update(Video video) throws SystemException {
		return getPersistence().update(video);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Video update(Video video, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(video, serviceContext);
	}

	/**
	* Returns all the videos where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducer(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProducer(producerId);
	}

	/**
	* Returns a range of all the videos where producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducer(
		long producerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProducer(producerId, start, end);
	}

	/**
	* Returns an ordered range of all the videos where producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducer(
		long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducer(producerId, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByProducer_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducer_First(producerId, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByProducer_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducer_First(producerId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByProducer_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducer_Last(producerId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByProducer_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducer_Last(producerId, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByProducer_PrevAndNext(
		long videoId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducer_PrevAndNext(videoId, producerId,
			orderByComparator);
	}

	/**
	* Removes all the videos where producerId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProducer(producerId);
	}

	/**
	* Returns the number of videos where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProducer(producerId);
	}

	/**
	* Returns all the videos where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId);
	}

	/**
	* Returns a range of all the videos where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId, start, end);
	}

	/**
	* Returns an ordered range of all the videos where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseries(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLectureseries_First(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByLectureseries_PrevAndNext(
		long videoId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLectureseries_PrevAndNext(videoId, lectureseriesId,
			orderByComparator);
	}

	/**
	* Removes all the videos where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	* Returns the number of videos where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	* Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerAndLectureseries(producerId, lectureseriesId);
	}

	/**
	* Returns a range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerAndLectureseries(producerId, lectureseriesId,
			start, end);
	}

	/**
	* Returns an ordered range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerAndLectureseries(producerId, lectureseriesId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByProducerAndLectureseries_First(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducerAndLectureseries_First(producerId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByProducerAndLectureseries_First(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducerAndLectureseries_First(producerId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByProducerAndLectureseries_Last(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducerAndLectureseries_Last(producerId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByProducerAndLectureseries_Last(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducerAndLectureseries_Last(producerId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByProducerAndLectureseries_PrevAndNext(
		long videoId, long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducerAndLectureseries_PrevAndNext(videoId,
			producerId, lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProducerAndLectureseries(long producerId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProducerAndLectureseries(producerId, lectureseriesId);
	}

	/**
	* Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProducerAndLectureseries(long producerId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProducerAndLectureseries(producerId, lectureseriesId);
	}

	/**
	* Returns all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerAndDownloadLink(producerId, downloadLink);
	}

	/**
	* Returns a range of all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerAndDownloadLink(producerId, downloadLink,
			start, end);
	}

	/**
	* Returns an ordered range of all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerAndDownloadLink(producerId, downloadLink,
			start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByProducerAndDownloadLink_First(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducerAndDownloadLink_First(producerId,
			downloadLink, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByProducerAndDownloadLink_First(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducerAndDownloadLink_First(producerId,
			downloadLink, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByProducerAndDownloadLink_Last(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducerAndDownloadLink_Last(producerId,
			downloadLink, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByProducerAndDownloadLink_Last(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducerAndDownloadLink_Last(producerId,
			downloadLink, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByProducerAndDownloadLink_PrevAndNext(
		long videoId, long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByProducerAndDownloadLink_PrevAndNext(videoId,
			producerId, downloadLink, orderByComparator);
	}

	/**
	* Removes all the videos where producerId = &#63; and downloadLink = &#63; from the database.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProducerAndDownloadLink(long producerId,
		int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProducerAndDownloadLink(producerId, downloadLink);
	}

	/**
	* Returns the number of videos where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProducerAndDownloadLink(long producerId,
		int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProducerAndDownloadLink(producerId, downloadLink);
	}

	/**
	* Returns all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesAndOpenaccess(lectureseriesId, openAccess);
	}

	/**
	* Returns a range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesAndOpenaccess(lectureseriesId,
			openAccess, start, end);
	}

	/**
	* Returns an ordered range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesAndOpenaccess(lectureseriesId,
			openAccess, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByLectureseriesAndOpenaccess_First(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLectureseriesAndOpenaccess_First(lectureseriesId,
			openAccess, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByLectureseriesAndOpenaccess_First(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesAndOpenaccess_First(lectureseriesId,
			openAccess, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByLectureseriesAndOpenaccess_Last(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLectureseriesAndOpenaccess_Last(lectureseriesId,
			openAccess, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByLectureseriesAndOpenaccess_Last(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesAndOpenaccess_Last(lectureseriesId,
			openAccess, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByLectureseriesAndOpenaccess_PrevAndNext(
		long videoId, long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLectureseriesAndOpenaccess_PrevAndNext(videoId,
			lectureseriesId, openAccess, orderByComparator);
	}

	/**
	* Removes all the videos where lectureseriesId = &#63; and openAccess = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByLectureseriesAndOpenaccess(lectureseriesId, openAccess);
	}

	/**
	* Returns the number of videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLectureseriesAndOpenaccess(lectureseriesId,
			openAccess);
	}

	/**
	* Returns all the videos where filename = &#63;.
	*
	* @param filename the filename
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByFilename(
		java.lang.String filename)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFilename(filename);
	}

	/**
	* Returns a range of all the videos where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByFilename(
		java.lang.String filename, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFilename(filename, start, end);
	}

	/**
	* Returns an ordered range of all the videos where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByFilename(
		java.lang.String filename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilename(filename, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByFilename_First(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByFilename_First(filename, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByFilename_First(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFilename_First(filename, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByFilename_Last(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByFilename_Last(filename, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByFilename_Last(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFilename_Last(filename, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where filename = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByFilename_PrevAndNext(
		long videoId, java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByFilename_PrevAndNext(videoId, filename,
			orderByComparator);
	}

	/**
	* Removes all the videos where filename = &#63; from the database.
	*
	* @param filename the filename
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFilename(java.lang.String filename)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFilename(filename);
	}

	/**
	* Returns the number of videos where filename = &#63;.
	*
	* @param filename the filename
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFilename(java.lang.String filename)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFilename(filename);
	}

	/**
	* Returns all the videos where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByUploadDate(
		java.util.Date uploadDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUploadDate(uploadDate);
	}

	/**
	* Returns a range of all the videos where uploadDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uploadDate the upload date
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByUploadDate(
		java.util.Date uploadDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUploadDate(uploadDate, start, end);
	}

	/**
	* Returns an ordered range of all the videos where uploadDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uploadDate the upload date
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByUploadDate(
		java.util.Date uploadDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUploadDate(uploadDate, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByUploadDate_First(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByUploadDate_First(uploadDate, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByUploadDate_First(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUploadDate_First(uploadDate, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByUploadDate_Last(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByUploadDate_Last(uploadDate, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByUploadDate_Last(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUploadDate_Last(uploadDate, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where uploadDate = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByUploadDate_PrevAndNext(
		long videoId, java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByUploadDate_PrevAndNext(videoId, uploadDate,
			orderByComparator);
	}

	/**
	* Removes all the videos where uploadDate = &#63; from the database.
	*
	* @param uploadDate the upload date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUploadDate(java.util.Date uploadDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUploadDate(uploadDate);
	}

	/**
	* Returns the number of videos where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUploadDate(java.util.Date uploadDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUploadDate(uploadDate);
	}

	/**
	* Returns all the videos where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByRootInstitution(
		long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRootInstitution(rootInstitutionId);
	}

	/**
	* Returns a range of all the videos where rootInstitutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rootInstitutionId the root institution ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByRootInstitution(
		long rootInstitutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRootInstitution(rootInstitutionId, start, end);
	}

	/**
	* Returns an ordered range of all the videos where rootInstitutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rootInstitutionId the root institution ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByRootInstitution(
		long rootInstitutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRootInstitution(rootInstitutionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByRootInstitution_First(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByRootInstitution_First(rootInstitutionId,
			orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByRootInstitution_First(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRootInstitution_First(rootInstitutionId,
			orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByRootInstitution_Last(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByRootInstitution_Last(rootInstitutionId,
			orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByRootInstitution_Last(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRootInstitution_Last(rootInstitutionId,
			orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByRootInstitution_PrevAndNext(
		long videoId, long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByRootInstitution_PrevAndNext(videoId,
			rootInstitutionId, orderByComparator);
	}

	/**
	* Removes all the videos where rootInstitutionId = &#63; from the database.
	*
	* @param rootInstitutionId the root institution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRootInstitution(long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRootInstitution(rootInstitutionId);
	}

	/**
	* Returns the number of videos where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRootInstitution(long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRootInstitution(rootInstitutionId);
	}

	/**
	* Returns all the videos where password = &#63;.
	*
	* @param password the password
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByPassword(
		java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPassword(password);
	}

	/**
	* Returns a range of all the videos where password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param password the password
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByPassword(
		java.lang.String password, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPassword(password, start, end);
	}

	/**
	* Returns an ordered range of all the videos where password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param password the password
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByPassword(
		java.lang.String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPassword(password, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByPassword_First(password, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPassword_First(password, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByPassword_Last(password, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPassword_Last(password, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where password = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByPassword_PrevAndNext(
		long videoId, java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByPassword_PrevAndNext(videoId, password,
			orderByComparator);
	}

	/**
	* Removes all the videos where password = &#63; from the database.
	*
	* @param password the password
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPassword(password);
	}

	/**
	* Returns the number of videos where password = &#63;.
	*
	* @param password the password
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPassword(password);
	}

	/**
	* Returns all the videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccess(
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOpenAccess(openAccess);
	}

	/**
	* Returns a range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccess(
		int openAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOpenAccess(openAccess, start, end);
	}

	/**
	* Returns an ordered range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccess(
		int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenAccess(openAccess, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByOpenAccess_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByOpenAccess_First(openAccess, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByOpenAccess_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenAccess_First(openAccess, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByOpenAccess_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByOpenAccess_Last(openAccess, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByOpenAccess_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenAccess_Last(openAccess, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByOpenAccess_PrevAndNext(
		long videoId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByOpenAccess_PrevAndNext(videoId, openAccess,
			orderByComparator);
	}

	/**
	* Removes all the videos where openAccess = &#63; from the database.
	*
	* @param openAccess the open access
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOpenAccess(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOpenAccess(openAccess);
	}

	/**
	* Returns the number of videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOpenAccess(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOpenAccess(openAccess);
	}

	/**
	* Returns all the videos where termId = &#63;.
	*
	* @param termId the term ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByTerm(
		long termId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTerm(termId);
	}

	/**
	* Returns a range of all the videos where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByTerm(
		long termId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTerm(termId, start, end);
	}

	/**
	* Returns an ordered range of all the videos where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByTerm(
		long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTerm(termId, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByTerm_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByTerm_First(termId, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByTerm_First(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTerm_First(termId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByTerm_Last(termId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTerm_Last(termId, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where termId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByTerm_PrevAndNext(
		long videoId, long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByTerm_PrevAndNext(videoId, termId, orderByComparator);
	}

	/**
	* Removes all the videos where termId = &#63; from the database.
	*
	* @param termId the term ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTerm(long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTerm(termId);
	}

	/**
	* Returns the number of videos where termId = &#63;.
	*
	* @param termId the term ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTerm(long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTerm(termId);
	}

	/**
	* Returns all the videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccessAndUploadedFile(
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOpenAccessAndUploadedFile(openAccess);
	}

	/**
	* Returns a range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenAccessAndUploadedFile(openAccess, start, end);
	}

	/**
	* Returns an ordered range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenAccessAndUploadedFile(openAccess, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByOpenAccessAndUploadedFile_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByOpenAccessAndUploadedFile_First(openAccess,
			orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByOpenAccessAndUploadedFile_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenAccessAndUploadedFile_First(openAccess,
			orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByOpenAccessAndUploadedFile_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByOpenAccessAndUploadedFile_Last(openAccess,
			orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByOpenAccessAndUploadedFile_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenAccessAndUploadedFile_Last(openAccess,
			orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByOpenAccessAndUploadedFile_PrevAndNext(
		long videoId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByOpenAccessAndUploadedFile_PrevAndNext(videoId,
			openAccess, orderByComparator);
	}

	/**
	* Removes all the videos where openAccess = &#63; from the database.
	*
	* @param openAccess the open access
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOpenAccessAndUploadedFile(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOpenAccessAndUploadedFile(openAccess);
	}

	/**
	* Returns the number of videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOpenAccessAndUploadedFile(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOpenAccessAndUploadedFile(openAccess);
	}

	/**
	* Returns all the videos where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLicense(
		long licenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLicense(licenseId);
	}

	/**
	* Returns a range of all the videos where licenseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param licenseId the license ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLicense(
		long licenseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLicense(licenseId, start, end);
	}

	/**
	* Returns an ordered range of all the videos where licenseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param licenseId the license ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findByLicense(
		long licenseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLicense(licenseId, start, end, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByLicense_First(
		long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByLicense_First(licenseId, orderByComparator);
	}

	/**
	* Returns the first video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByLicense_First(
		long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLicense_First(licenseId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByLicense_Last(
		long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByLicense_Last(licenseId, orderByComparator);
	}

	/**
	* Returns the last video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByLicense_Last(
		long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLicense_Last(licenseId, orderByComparator);
	}

	/**
	* Returns the videos before and after the current video in the ordered set where licenseId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video[] findByLicense_PrevAndNext(
		long videoId, long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence()
				   .findByLicense_PrevAndNext(videoId, licenseId,
			orderByComparator);
	}

	/**
	* Removes all the videos where licenseId = &#63; from the database.
	*
	* @param licenseId the license ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLicense(licenseId);
	}

	/**
	* Returns the number of videos where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLicense(licenseId);
	}

	/**
	* Caches the video in the entity cache if it is enabled.
	*
	* @param video the video
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.Video video) {
		getPersistence().cacheResult(video);
	}

	/**
	* Caches the videos in the entity cache if it is enabled.
	*
	* @param videos the videos
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video> videos) {
		getPersistence().cacheResult(videos);
	}

	/**
	* Creates a new video with the primary key. Does not add the video to the database.
	*
	* @param videoId the primary key for the new video
	* @return the new video
	*/
	public static de.uhh.l2g.plugins.model.Video create(long videoId) {
		return getPersistence().create(videoId);
	}

	/**
	* Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video
	* @return the video that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video remove(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().remove(videoId);
	}

	public static de.uhh.l2g.plugins.model.Video updateImpl(
		de.uhh.l2g.plugins.model.Video video)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(video);
	}

	/**
	* Returns the video with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideoException} if it could not be found.
	*
	* @param videoId the primary key of the video
	* @return the video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video findByPrimaryKey(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException {
		return getPersistence().findByPrimaryKey(videoId);
	}

	/**
	* Returns the video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video
	* @return the video, or <code>null</code> if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video fetchByPrimaryKey(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoId);
	}

	/**
	* Returns all the videos.
	*
	* @return the videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of videos.
	*
	* @return the number of videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					VideoPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VideoPersistence persistence) {
	}

	private static VideoPersistence _persistence;
}
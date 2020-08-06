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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Video_Creator;

/**
 * The persistence interface for the video_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorPersistenceImpl
 * @see Video_CreatorUtil
 * @generated
 */
public interface Video_CreatorPersistence extends BasePersistence<Video_Creator> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Video_CreatorUtil} to access the video_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the video_ creators where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video_ creators where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video_ creators where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoCreatorId the primary key of the current video_ creator
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator[] findByVideo_PrevAndNext(
		long videoCreatorId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Removes all the video_ creators where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video_ creators where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video_ creators where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByCreator(
		long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video_ creators where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByCreator(
		long creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video_ creators where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByCreator(
		long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the first video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the last video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param videoCreatorId the primary key of the current video_ creator
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator[] findByCreator_PrevAndNext(
		long videoCreatorId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Removes all the video_ creators where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video_ creators where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @return the matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideoCreator(
		long videoId, long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByVideoCreator_First(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByVideoCreator_First(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByVideoCreator_Last(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByVideoCreator_Last(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoCreatorId the primary key of the current video_ creator
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator[] findByVideoCreator_PrevAndNext(
		long videoCreatorId, long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoCreator(long videoId, long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @return the number of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoCreator(long videoId, long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the video_ creator in the entity cache if it is enabled.
	*
	* @param video_Creator the video_ creator
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator);

	/**
	* Caches the video_ creators in the entity cache if it is enabled.
	*
	* @param video_Creators the video_ creators
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video_Creator> video_Creators);

	/**
	* Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	*
	* @param videoCreatorId the primary key for the new video_ creator
	* @return the new video_ creator
	*/
	public de.uhh.l2g.plugins.model.Video_Creator create(long videoCreatorId);

	/**
	* Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator remove(long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	public de.uhh.l2g.plugins.model.Video_Creator updateImpl(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video_ creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_CreatorException} if it could not be found.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator findByPrimaryKey(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException;

	/**
	* Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video_Creator fetchByPrimaryKey(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video_ creators.
	*
	* @return the video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video_ creators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video_ creators.
	*
	* @return the number of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
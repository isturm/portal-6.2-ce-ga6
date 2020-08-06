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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries
 * @generated
 */
public class LectureseriesWrapper implements Lectureseries,
	ModelWrapper<Lectureseries> {
	public LectureseriesWrapper(Lectureseries lectureseries) {
		_lectureseries = lectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("number", getNumber());
		attributes.put("eventType", getEventType());
		attributes.put("categoryId", getCategoryId());
		attributes.put("name", getName());
		attributes.put("shortDesc", getShortDesc());
		attributes.put("termId", getTermId());
		attributes.put("language", getLanguage());
		attributes.put("facultyName", getFacultyName());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("password", getPassword());
		attributes.put("approved", getApproved());
		attributes.put("longDesc", getLongDesc());
		attributes.put("latestOpenAccessVideoId", getLatestOpenAccessVideoId());
		attributes.put("latestVideoUploadDate", getLatestVideoUploadDate());
		attributes.put("latestVideoGenerationDate",
			getLatestVideoGenerationDate());
		attributes.put("videoSort", getVideoSort());
		attributes.put("USID", getUSID());
		attributes.put("previewVideoId", getPreviewVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDesc = (String)attributes.get("shortDesc");

		if (shortDesc != null) {
			setShortDesc(shortDesc);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		String longDesc = (String)attributes.get("longDesc");

		if (longDesc != null) {
			setLongDesc(longDesc);
		}

		Long latestOpenAccessVideoId = (Long)attributes.get(
				"latestOpenAccessVideoId");

		if (latestOpenAccessVideoId != null) {
			setLatestOpenAccessVideoId(latestOpenAccessVideoId);
		}

		Date latestVideoUploadDate = (Date)attributes.get(
				"latestVideoUploadDate");

		if (latestVideoUploadDate != null) {
			setLatestVideoUploadDate(latestVideoUploadDate);
		}

		String latestVideoGenerationDate = (String)attributes.get(
				"latestVideoGenerationDate");

		if (latestVideoGenerationDate != null) {
			setLatestVideoGenerationDate(latestVideoGenerationDate);
		}

		Integer videoSort = (Integer)attributes.get("videoSort");

		if (videoSort != null) {
			setVideoSort(videoSort);
		}

		String USID = (String)attributes.get("USID");

		if (USID != null) {
			setUSID(USID);
		}

		Long previewVideoId = (Long)attributes.get("previewVideoId");

		if (previewVideoId != null) {
			setPreviewVideoId(previewVideoId);
		}
	}

	/**
	* Returns the primary key of this lectureseries.
	*
	* @return the primary key of this lectureseries
	*/
	@Override
	public long getPrimaryKey() {
		return _lectureseries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lectureseries.
	*
	* @param primaryKey the primary key of this lectureseries
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lectureseries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the number of this lectureseries.
	*
	* @return the number of this lectureseries
	*/
	@Override
	public java.lang.String getNumber() {
		return _lectureseries.getNumber();
	}

	/**
	* Sets the number of this lectureseries.
	*
	* @param number the number of this lectureseries
	*/
	@Override
	public void setNumber(java.lang.String number) {
		_lectureseries.setNumber(number);
	}

	/**
	* Returns the event type of this lectureseries.
	*
	* @return the event type of this lectureseries
	*/
	@Override
	public java.lang.String getEventType() {
		return _lectureseries.getEventType();
	}

	/**
	* Sets the event type of this lectureseries.
	*
	* @param eventType the event type of this lectureseries
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_lectureseries.setEventType(eventType);
	}

	/**
	* Returns the category ID of this lectureseries.
	*
	* @return the category ID of this lectureseries
	*/
	@Override
	public long getCategoryId() {
		return _lectureseries.getCategoryId();
	}

	/**
	* Sets the category ID of this lectureseries.
	*
	* @param categoryId the category ID of this lectureseries
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_lectureseries.setCategoryId(categoryId);
	}

	/**
	* Returns the name of this lectureseries.
	*
	* @return the name of this lectureseries
	*/
	@Override
	public java.lang.String getName() {
		return _lectureseries.getName();
	}

	/**
	* Sets the name of this lectureseries.
	*
	* @param name the name of this lectureseries
	*/
	@Override
	public void setName(java.lang.String name) {
		_lectureseries.setName(name);
	}

	/**
	* Returns the short desc of this lectureseries.
	*
	* @return the short desc of this lectureseries
	*/
	@Override
	public java.lang.String getShortDesc() {
		return _lectureseries.getShortDesc();
	}

	/**
	* Sets the short desc of this lectureseries.
	*
	* @param shortDesc the short desc of this lectureseries
	*/
	@Override
	public void setShortDesc(java.lang.String shortDesc) {
		_lectureseries.setShortDesc(shortDesc);
	}

	/**
	* Returns the term ID of this lectureseries.
	*
	* @return the term ID of this lectureseries
	*/
	@Override
	public long getTermId() {
		return _lectureseries.getTermId();
	}

	/**
	* Sets the term ID of this lectureseries.
	*
	* @param termId the term ID of this lectureseries
	*/
	@Override
	public void setTermId(long termId) {
		_lectureseries.setTermId(termId);
	}

	/**
	* Returns the language of this lectureseries.
	*
	* @return the language of this lectureseries
	*/
	@Override
	public java.lang.String getLanguage() {
		return _lectureseries.getLanguage();
	}

	/**
	* Sets the language of this lectureseries.
	*
	* @param language the language of this lectureseries
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_lectureseries.setLanguage(language);
	}

	/**
	* Returns the faculty name of this lectureseries.
	*
	* @return the faculty name of this lectureseries
	*/
	@Override
	public java.lang.String getFacultyName() {
		return _lectureseries.getFacultyName();
	}

	/**
	* Sets the faculty name of this lectureseries.
	*
	* @param facultyName the faculty name of this lectureseries
	*/
	@Override
	public void setFacultyName(java.lang.String facultyName) {
		_lectureseries.setFacultyName(facultyName);
	}

	/**
	* Returns the lectureseries ID of this lectureseries.
	*
	* @return the lectureseries ID of this lectureseries
	*/
	@Override
	public long getLectureseriesId() {
		return _lectureseries.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this lectureseries.
	*
	* @param lectureseriesId the lectureseries ID of this lectureseries
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseries.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the password of this lectureseries.
	*
	* @return the password of this lectureseries
	*/
	@Override
	public java.lang.String getPassword() {
		return _lectureseries.getPassword();
	}

	/**
	* Sets the password of this lectureseries.
	*
	* @param password the password of this lectureseries
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_lectureseries.setPassword(password);
	}

	/**
	* Returns the approved of this lectureseries.
	*
	* @return the approved of this lectureseries
	*/
	@Override
	public int getApproved() {
		return _lectureseries.getApproved();
	}

	/**
	* Sets the approved of this lectureseries.
	*
	* @param approved the approved of this lectureseries
	*/
	@Override
	public void setApproved(int approved) {
		_lectureseries.setApproved(approved);
	}

	/**
	* Returns the long desc of this lectureseries.
	*
	* @return the long desc of this lectureseries
	*/
	@Override
	public java.lang.String getLongDesc() {
		return _lectureseries.getLongDesc();
	}

	/**
	* Sets the long desc of this lectureseries.
	*
	* @param longDesc the long desc of this lectureseries
	*/
	@Override
	public void setLongDesc(java.lang.String longDesc) {
		_lectureseries.setLongDesc(longDesc);
	}

	/**
	* Returns the latest open access video ID of this lectureseries.
	*
	* @return the latest open access video ID of this lectureseries
	*/
	@Override
	public long getLatestOpenAccessVideoId() {
		return _lectureseries.getLatestOpenAccessVideoId();
	}

	/**
	* Sets the latest open access video ID of this lectureseries.
	*
	* @param latestOpenAccessVideoId the latest open access video ID of this lectureseries
	*/
	@Override
	public void setLatestOpenAccessVideoId(long latestOpenAccessVideoId) {
		_lectureseries.setLatestOpenAccessVideoId(latestOpenAccessVideoId);
	}

	/**
	* Returns the latest video upload date of this lectureseries.
	*
	* @return the latest video upload date of this lectureseries
	*/
	@Override
	public java.util.Date getLatestVideoUploadDate() {
		return _lectureseries.getLatestVideoUploadDate();
	}

	/**
	* Sets the latest video upload date of this lectureseries.
	*
	* @param latestVideoUploadDate the latest video upload date of this lectureseries
	*/
	@Override
	public void setLatestVideoUploadDate(java.util.Date latestVideoUploadDate) {
		_lectureseries.setLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	* Returns the latest video generation date of this lectureseries.
	*
	* @return the latest video generation date of this lectureseries
	*/
	@Override
	public java.lang.String getLatestVideoGenerationDate() {
		return _lectureseries.getLatestVideoGenerationDate();
	}

	/**
	* Sets the latest video generation date of this lectureseries.
	*
	* @param latestVideoGenerationDate the latest video generation date of this lectureseries
	*/
	@Override
	public void setLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate) {
		_lectureseries.setLatestVideoGenerationDate(latestVideoGenerationDate);
	}

	/**
	* Returns the video sort of this lectureseries.
	*
	* @return the video sort of this lectureseries
	*/
	@Override
	public int getVideoSort() {
		return _lectureseries.getVideoSort();
	}

	/**
	* Sets the video sort of this lectureseries.
	*
	* @param videoSort the video sort of this lectureseries
	*/
	@Override
	public void setVideoSort(int videoSort) {
		_lectureseries.setVideoSort(videoSort);
	}

	/**
	* Returns the u s i d of this lectureseries.
	*
	* @return the u s i d of this lectureseries
	*/
	@Override
	public java.lang.String getUSID() {
		return _lectureseries.getUSID();
	}

	/**
	* Sets the u s i d of this lectureseries.
	*
	* @param USID the u s i d of this lectureseries
	*/
	@Override
	public void setUSID(java.lang.String USID) {
		_lectureseries.setUSID(USID);
	}

	/**
	* Returns the preview video ID of this lectureseries.
	*
	* @return the preview video ID of this lectureseries
	*/
	@Override
	public long getPreviewVideoId() {
		return _lectureseries.getPreviewVideoId();
	}

	/**
	* Sets the preview video ID of this lectureseries.
	*
	* @param previewVideoId the preview video ID of this lectureseries
	*/
	@Override
	public void setPreviewVideoId(long previewVideoId) {
		_lectureseries.setPreviewVideoId(previewVideoId);
	}

	@Override
	public boolean isNew() {
		return _lectureseries.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lectureseries.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lectureseries.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lectureseries.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lectureseries.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lectureseries.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lectureseries.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LectureseriesWrapper((Lectureseries)_lectureseries.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		return _lectureseries.compareTo(lectureseries);
	}

	@Override
	public int hashCode() {
		return _lectureseries.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Lectureseries> toCacheModel() {
		return _lectureseries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries toEscapedModel() {
		return new LectureseriesWrapper(_lectureseries.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries toUnescapedModel() {
		return new LectureseriesWrapper(_lectureseries.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lectureseries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lectureseries.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lectureseries.persist();
	}

	@Override
	public int getNumberOfVideos() {
		return _lectureseries.getNumberOfVideos();
	}

	@Override
	public int getNumberOfOpenAccessVideos() {
		return _lectureseries.getNumberOfOpenAccessVideos();
	}

	@Override
	public java.lang.String getType() {
		return _lectureseries.getType();
	}

	@Override
	public void setType(java.lang.String type) {
		_lectureseries.setType(type);
	}

	@Override
	public java.lang.String getClosedAccessURI() {
		return _lectureseries.getClosedAccessURI();
	}

	@Override
	public java.lang.String getOpenAccessURI() {
		return _lectureseries.getOpenAccessURI();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LectureseriesWrapper)) {
			return false;
		}

		LectureseriesWrapper lectureseriesWrapper = (LectureseriesWrapper)obj;

		if (Validator.equals(_lectureseries, lectureseriesWrapper._lectureseries)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Lectureseries getWrappedLectureseries() {
		return _lectureseries;
	}

	@Override
	public Lectureseries getWrappedModel() {
		return _lectureseries;
	}

	@Override
	public void resetOriginalValues() {
		_lectureseries.resetOriginalValues();
	}

	private Lectureseries _lectureseries;
}
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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Segment service. Represents a row in the &quot;LG_Segment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see SegmentModel
 * @see de.uhh.l2g.plugins.model.impl.SegmentImpl
 * @see de.uhh.l2g.plugins.model.impl.SegmentModelImpl
 * @generated
 */
public interface Segment extends SegmentModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.SegmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public long getPreviusSegmentId();

	public void setPreviusSegmentId(long previusSegmentId);

	public int getSeconds();

	public void setSeconds(int seconds);

	public int getNumber();

	public void setNumber(int number);

	public java.lang.String getImage();

	public void setImage(java.lang.String image);
}
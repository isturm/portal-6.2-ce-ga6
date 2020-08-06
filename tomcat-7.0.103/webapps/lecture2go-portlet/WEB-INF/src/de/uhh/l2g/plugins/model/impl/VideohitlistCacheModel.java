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

package de.uhh.l2g.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Videohitlist;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Videohitlist in entity cache.
 *
 * @author Iavor Sturm
 * @see Videohitlist
 * @generated
 */
public class VideohitlistCacheModel implements CacheModel<Videohitlist>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{videohitlistId=");
		sb.append(videohitlistId);
		sb.append(", hitsPerDay=");
		sb.append(hitsPerDay);
		sb.append(", hitsPerWeek=");
		sb.append(hitsPerWeek);
		sb.append(", hitsPerMonth=");
		sb.append(hitsPerMonth);
		sb.append(", hitsPerYear=");
		sb.append(hitsPerYear);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Videohitlist toEntityModel() {
		VideohitlistImpl videohitlistImpl = new VideohitlistImpl();

		videohitlistImpl.setVideohitlistId(videohitlistId);
		videohitlistImpl.setHitsPerDay(hitsPerDay);
		videohitlistImpl.setHitsPerWeek(hitsPerWeek);
		videohitlistImpl.setHitsPerMonth(hitsPerMonth);
		videohitlistImpl.setHitsPerYear(hitsPerYear);
		videohitlistImpl.setVideoId(videoId);

		videohitlistImpl.resetOriginalValues();

		return videohitlistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videohitlistId = objectInput.readLong();
		hitsPerDay = objectInput.readLong();
		hitsPerWeek = objectInput.readLong();
		hitsPerMonth = objectInput.readLong();
		hitsPerYear = objectInput.readLong();
		videoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videohitlistId);
		objectOutput.writeLong(hitsPerDay);
		objectOutput.writeLong(hitsPerWeek);
		objectOutput.writeLong(hitsPerMonth);
		objectOutput.writeLong(hitsPerYear);
		objectOutput.writeLong(videoId);
	}

	public long videohitlistId;
	public long hitsPerDay;
	public long hitsPerWeek;
	public long hitsPerMonth;
	public long hitsPerYear;
	public long videoId;
}
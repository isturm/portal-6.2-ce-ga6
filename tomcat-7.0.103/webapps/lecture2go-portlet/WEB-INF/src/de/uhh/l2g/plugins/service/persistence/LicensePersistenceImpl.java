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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.LicenseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicensePersistence
 * @see LicenseUtil
 * @generated
 */
public class LicensePersistenceImpl extends BasePersistenceImpl<License>
	implements LicensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LicenseUtil} to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LicenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SELECTABLE =
		new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySelectable",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTABLE =
		new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySelectable",
			new String[] { Boolean.class.getName() },
			LicenseModelImpl.SELECTABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SELECTABLE = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySelectable",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the matching licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findBySelectable(boolean selectable)
		throws SystemException {
		return findBySelectable(selectable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of matching licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findBySelectable(boolean selectable, int start, int end)
		throws SystemException {
		return findBySelectable(selectable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findBySelectable(boolean selectable, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTABLE;
			finderArgs = new Object[] { selectable };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SELECTABLE;
			finderArgs = new Object[] { selectable, start, end, orderByComparator };
		}

		List<License> list = (List<License>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (License license : list) {
				if ((selectable != license.getSelectable())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LICENSE_WHERE);

			query.append(_FINDER_COLUMN_SELECTABLE_SELECTABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(selectable);

				if (!pagination) {
					list = (List<License>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<License>(list);
				}
				else {
					list = (List<License>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a matching license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License findBySelectable_First(boolean selectable,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		License license = fetchBySelectable_First(selectable, orderByComparator);

		if (license != null) {
			return license;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("selectable=");
		msg.append(selectable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLicenseException(msg.toString());
	}

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license, or <code>null</code> if a matching license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License fetchBySelectable_First(boolean selectable,
		OrderByComparator orderByComparator) throws SystemException {
		List<License> list = findBySelectable(selectable, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a matching license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License findBySelectable_Last(boolean selectable,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		License license = fetchBySelectable_Last(selectable, orderByComparator);

		if (license != null) {
			return license;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("selectable=");
		msg.append(selectable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLicenseException(msg.toString());
	}

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license, or <code>null</code> if a matching license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License fetchBySelectable_Last(boolean selectable,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySelectable(selectable);

		if (count == 0) {
			return null;
		}

		List<License> list = findBySelectable(selectable, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licenses before and after the current license in the ordered set where selectable = &#63;.
	 *
	 * @param licenseId the primary key of the current license
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License[] findBySelectable_PrevAndNext(long licenseId,
		boolean selectable, OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		License license = findByPrimaryKey(licenseId);

		Session session = null;

		try {
			session = openSession();

			License[] array = new LicenseImpl[3];

			array[0] = getBySelectable_PrevAndNext(session, license,
					selectable, orderByComparator, true);

			array[1] = license;

			array[2] = getBySelectable_PrevAndNext(session, license,
					selectable, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected License getBySelectable_PrevAndNext(Session session,
		License license, boolean selectable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICENSE_WHERE);

		query.append(_FINDER_COLUMN_SELECTABLE_SELECTABLE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(selectable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(license);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<License> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the licenses where selectable = &#63; from the database.
	 *
	 * @param selectable the selectable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySelectable(boolean selectable)
		throws SystemException {
		for (License license : findBySelectable(selectable, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(license);
		}
	}

	/**
	 * Returns the number of licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the number of matching licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySelectable(boolean selectable) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SELECTABLE;

		Object[] finderArgs = new Object[] { selectable };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENSE_WHERE);

			query.append(_FINDER_COLUMN_SELECTABLE_SELECTABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(selectable);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SELECTABLE_SELECTABLE_2 = "license.selectable = ?";

	public LicensePersistenceImpl() {
		setModelClass(License.class);
	}

	/**
	 * Caches the license in the entity cache if it is enabled.
	 *
	 * @param license the license
	 */
	@Override
	public void cacheResult(License license) {
		EntityCacheUtil.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey(), license);

		license.resetOriginalValues();
	}

	/**
	 * Caches the licenses in the entity cache if it is enabled.
	 *
	 * @param licenses the licenses
	 */
	@Override
	public void cacheResult(List<License> licenses) {
		for (License license : licenses) {
			if (EntityCacheUtil.getResult(
						LicenseModelImpl.ENTITY_CACHE_ENABLED,
						LicenseImpl.class, license.getPrimaryKey()) == null) {
				cacheResult(license);
			}
			else {
				license.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all licenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LicenseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LicenseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the license.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(License license) {
		EntityCacheUtil.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<License> licenses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (License license : licenses) {
			EntityCacheUtil.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
				LicenseImpl.class, license.getPrimaryKey());
		}
	}

	/**
	 * Creates a new license with the primary key. Does not add the license to the database.
	 *
	 * @param licenseId the primary key for the new license
	 * @return the new license
	 */
	@Override
	public License create(long licenseId) {
		License license = new LicenseImpl();

		license.setNew(true);
		license.setPrimaryKey(licenseId);

		return license;
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License remove(long licenseId)
		throws NoSuchLicenseException, SystemException {
		return remove((Serializable)licenseId);
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License remove(Serializable primaryKey)
		throws NoSuchLicenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			License license = (License)session.get(LicenseImpl.class, primaryKey);

			if (license == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(license);
		}
		catch (NoSuchLicenseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected License removeImpl(License license) throws SystemException {
		license = toUnwrappedModel(license);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(license)) {
				license = (License)session.get(LicenseImpl.class,
						license.getPrimaryKeyObj());
			}

			if (license != null) {
				session.delete(license);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (license != null) {
			clearCache(license);
		}

		return license;
	}

	@Override
	public License updateImpl(de.uhh.l2g.plugins.model.License license)
		throws SystemException {
		license = toUnwrappedModel(license);

		boolean isNew = license.isNew();

		LicenseModelImpl licenseModelImpl = (LicenseModelImpl)license;

		Session session = null;

		try {
			session = openSession();

			if (license.isNew()) {
				session.save(license);

				license.setNew(false);
			}
			else {
				session.merge(license);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LicenseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((licenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						licenseModelImpl.getOriginalSelectable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELECTABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTABLE,
					args);

				args = new Object[] { licenseModelImpl.getSelectable() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELECTABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey(), license);

		return license;
	}

	protected License toUnwrappedModel(License license) {
		if (license instanceof LicenseImpl) {
			return license;
		}

		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setNew(license.isNew());
		licenseImpl.setPrimaryKey(license.getPrimaryKey());

		licenseImpl.setLicenseId(license.getLicenseId());
		licenseImpl.setFullName(license.getFullName());
		licenseImpl.setShortIdentifier(license.getShortIdentifier());
		licenseImpl.setUrl(license.getUrl());
		licenseImpl.setSchemeName(license.getSchemeName());
		licenseImpl.setSchemeUrl(license.getSchemeUrl());
		licenseImpl.setSelectable(license.isSelectable());
		licenseImpl.setDescription(license.getDescription());

		return licenseImpl;
	}

	/**
	 * Returns the license with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLicenseException, SystemException {
		License license = fetchByPrimaryKey(primaryKey);

		if (license == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLicenseException} if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License findByPrimaryKey(long licenseId)
		throws NoSuchLicenseException, SystemException {
		return findByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		License license = (License)EntityCacheUtil.getResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
				LicenseImpl.class, primaryKey);

		if (license == _nullLicense) {
			return null;
		}

		if (license == null) {
			Session session = null;

			try {
				session = openSession();

				license = (License)session.get(LicenseImpl.class, primaryKey);

				if (license != null) {
					cacheResult(license);
				}
				else {
					EntityCacheUtil.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
						LicenseImpl.class, primaryKey, _nullLicense);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
					LicenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License fetchByPrimaryKey(long licenseId) throws SystemException {
		return fetchByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns all the licenses.
	 *
	 * @return the licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<License> list = (List<License>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LICENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICENSE;

				if (pagination) {
					sql = sql.concat(LicenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<License>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<License>(list);
				}
				else {
					list = (List<License>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the licenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (License license : findAll()) {
			remove(license);
		}
	}

	/**
	 * Returns the number of licenses.
	 *
	 * @return the number of licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICENSE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the license persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.License")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<License>> listenersList = new ArrayList<ModelListener<License>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<License>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LicenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LICENSE = "SELECT license FROM License license";
	private static final String _SQL_SELECT_LICENSE_WHERE = "SELECT license FROM License license WHERE ";
	private static final String _SQL_COUNT_LICENSE = "SELECT COUNT(license) FROM License license";
	private static final String _SQL_COUNT_LICENSE_WHERE = "SELECT COUNT(license) FROM License license WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "license.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No License exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No License exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LicensePersistenceImpl.class);
	private static License _nullLicense = new LicenseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<License> toCacheModel() {
				return _nullLicenseCacheModel;
			}
		};

	private static CacheModel<License> _nullLicenseCacheModel = new CacheModel<License>() {
			@Override
			public License toEntityModel() {
				return _nullLicense;
			}
		};
}
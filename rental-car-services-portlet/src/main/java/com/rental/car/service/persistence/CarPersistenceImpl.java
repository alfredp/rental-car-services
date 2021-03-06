package com.rental.car.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rental.car.NoSuchCarException;
import com.rental.car.model.Car;
import com.rental.car.model.impl.CarImpl;
import com.rental.car.model.impl.CarModelImpl;
import com.rental.car.service.persistence.CarPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the car service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarPersistence
 * @see CarUtil
 * @generated
 */
public class CarPersistenceImpl extends BasePersistenceImpl<Car>
    implements CarPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CarUtil} to access the car persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CarImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            CarModelImpl.UUID_COLUMN_BITMASK |
            CarModelImpl.BRAND_COLUMN_BITMASK |
            CarModelImpl.MODEL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "car.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "car.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(car.uuid IS NULL OR car.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            CarModelImpl.UUID_COLUMN_BITMASK |
            CarModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "car.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "car.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(car.uuid IS NULL OR car.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "car.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            CarModelImpl.UUID_COLUMN_BITMASK |
            CarModelImpl.COMPANYID_COLUMN_BITMASK |
            CarModelImpl.BRAND_COLUMN_BITMASK |
            CarModelImpl.MODEL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "car.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "car.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(car.uuid IS NULL OR car.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "car.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRAND = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrand",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrand",
            new String[] { String.class.getName() },
            CarModelImpl.BRAND_COLUMN_BITMASK |
            CarModelImpl.MODEL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BRAND = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrand",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_BRAND_BRAND_1 = "car.brand IS NULL";
    private static final String _FINDER_COLUMN_BRAND_BRAND_2 = "car.brand = ?";
    private static final String _FINDER_COLUMN_BRAND_BRAND_3 = "(car.brand IS NULL OR car.brand = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODEL = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModel",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODEL = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, CarImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModel",
            new String[] { String.class.getName() },
            CarModelImpl.MODEL_COLUMN_BITMASK |
            CarModelImpl.BRAND_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODEL = new FinderPath(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModel",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_MODEL_MODEL_1 = "car.model IS NULL";
    private static final String _FINDER_COLUMN_MODEL_MODEL_2 = "car.model = ?";
    private static final String _FINDER_COLUMN_MODEL_MODEL_3 = "(car.model IS NULL OR car.model = '')";
    private static final String _SQL_SELECT_CAR = "SELECT car FROM Car car";
    private static final String _SQL_SELECT_CAR_WHERE = "SELECT car FROM Car car WHERE ";
    private static final String _SQL_COUNT_CAR = "SELECT COUNT(car) FROM Car car";
    private static final String _SQL_COUNT_CAR_WHERE = "SELECT COUNT(car) FROM Car car WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "car.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Car exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Car exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CarPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Car _nullCar = new CarImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Car> toCacheModel() {
                return _nullCarCacheModel;
            }
        };

    private static CacheModel<Car> _nullCarCacheModel = new CacheModel<Car>() {
            @Override
            public Car toEntityModel() {
                return _nullCar;
            }
        };

    public CarPersistenceImpl() {
        setModelClass(Car.class);
    }

    /**
     * Returns all the cars where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the cars where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @return the range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the cars where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Car> list = (List<Car>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Car car : list) {
                if (!Validator.equals(uuid, car.getUuid())) {
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
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CAR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CarModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Car>(list);
                } else {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first car in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByUuid_First(String uuid, OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByUuid_First(uuid, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the first car in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Car> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last car in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByUuid_Last(uuid, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the last car in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Car> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the cars before and after the current car in the ordered set where uuid = &#63;.
     *
     * @param carId the primary key of the current car
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next car
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car[] findByUuid_PrevAndNext(long carId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = findByPrimaryKey(carId);

        Session session = null;

        try {
            session = openSession();

            Car[] array = new CarImpl[3];

            array[0] = getByUuid_PrevAndNext(session, car, uuid,
                    orderByComparator, true);

            array[1] = car;

            array[2] = getByUuid_PrevAndNext(session, car, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Car getByUuid_PrevAndNext(Session session, Car car, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CAR_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CarModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(car);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Car> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the cars where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Car car : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(car);
        }
    }

    /**
     * Returns the number of cars where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CAR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the car where uuid = &#63; and groupId = &#63; or throws a {@link com.rental.car.NoSuchCarException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByUUID_G(String uuid, long groupId)
        throws NoSuchCarException, SystemException {
        Car car = fetchByUUID_G(uuid, groupId);

        if (car == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCarException(msg.toString());
        }

        return car;
    }

    /**
     * Returns the car where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the car where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Car) {
            Car car = (Car) result;

            if (!Validator.equals(uuid, car.getUuid()) ||
                    (groupId != car.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_CAR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Car> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Car car = list.get(0);

                    result = car;

                    cacheResult(car);

                    if ((car.getUuid() == null) || !car.getUuid().equals(uuid) ||
                            (car.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, car);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Car) result;
        }
    }

    /**
     * Removes the car where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the car that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car removeByUUID_G(String uuid, long groupId)
        throws NoSuchCarException, SystemException {
        Car car = findByUUID_G(uuid, groupId);

        return remove(car);
    }

    /**
     * Returns the number of cars where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CAR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the cars where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the cars where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @return the range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the cars where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Car> list = (List<Car>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Car car : list) {
                if (!Validator.equals(uuid, car.getUuid()) ||
                        (companyId != car.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_CAR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CarModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Car>(list);
                } else {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first car in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the first car in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Car> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last car in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the last car in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Car> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the cars before and after the current car in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param carId the primary key of the current car
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next car
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car[] findByUuid_C_PrevAndNext(long carId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = findByPrimaryKey(carId);

        Session session = null;

        try {
            session = openSession();

            Car[] array = new CarImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, car, uuid, companyId,
                    orderByComparator, true);

            array[1] = car;

            array[2] = getByUuid_C_PrevAndNext(session, car, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Car getByUuid_C_PrevAndNext(Session session, Car car,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CAR_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CarModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(car);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Car> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the cars where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Car car : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(car);
        }
    }

    /**
     * Returns the number of cars where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CAR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the cars where brand = &#63;.
     *
     * @param brand the brand
     * @return the matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByBrand(String brand) throws SystemException {
        return findByBrand(brand, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the cars where brand = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param brand the brand
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @return the range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByBrand(String brand, int start, int end)
        throws SystemException {
        return findByBrand(brand, start, end, null);
    }

    /**
     * Returns an ordered range of all the cars where brand = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param brand the brand
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByBrand(String brand, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND;
            finderArgs = new Object[] { brand };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRAND;
            finderArgs = new Object[] { brand, start, end, orderByComparator };
        }

        List<Car> list = (List<Car>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Car car : list) {
                if (!Validator.equals(brand, car.getBrand())) {
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
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CAR_WHERE);

            boolean bindBrand = false;

            if (brand == null) {
                query.append(_FINDER_COLUMN_BRAND_BRAND_1);
            } else if (brand.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BRAND_BRAND_3);
            } else {
                bindBrand = true;

                query.append(_FINDER_COLUMN_BRAND_BRAND_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CarModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindBrand) {
                    qPos.add(brand);
                }

                if (!pagination) {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Car>(list);
                } else {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first car in the ordered set where brand = &#63;.
     *
     * @param brand the brand
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByBrand_First(String brand,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByBrand_First(brand, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("brand=");
        msg.append(brand);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the first car in the ordered set where brand = &#63;.
     *
     * @param brand the brand
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByBrand_First(String brand,
        OrderByComparator orderByComparator) throws SystemException {
        List<Car> list = findByBrand(brand, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last car in the ordered set where brand = &#63;.
     *
     * @param brand the brand
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByBrand_Last(String brand,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByBrand_Last(brand, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("brand=");
        msg.append(brand);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the last car in the ordered set where brand = &#63;.
     *
     * @param brand the brand
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByBrand_Last(String brand,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByBrand(brand);

        if (count == 0) {
            return null;
        }

        List<Car> list = findByBrand(brand, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the cars before and after the current car in the ordered set where brand = &#63;.
     *
     * @param carId the primary key of the current car
     * @param brand the brand
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next car
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car[] findByBrand_PrevAndNext(long carId, String brand,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = findByPrimaryKey(carId);

        Session session = null;

        try {
            session = openSession();

            Car[] array = new CarImpl[3];

            array[0] = getByBrand_PrevAndNext(session, car, brand,
                    orderByComparator, true);

            array[1] = car;

            array[2] = getByBrand_PrevAndNext(session, car, brand,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Car getByBrand_PrevAndNext(Session session, Car car,
        String brand, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CAR_WHERE);

        boolean bindBrand = false;

        if (brand == null) {
            query.append(_FINDER_COLUMN_BRAND_BRAND_1);
        } else if (brand.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_BRAND_BRAND_3);
        } else {
            bindBrand = true;

            query.append(_FINDER_COLUMN_BRAND_BRAND_2);
        }

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CarModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindBrand) {
            qPos.add(brand);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(car);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Car> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the cars where brand = &#63; from the database.
     *
     * @param brand the brand
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByBrand(String brand) throws SystemException {
        for (Car car : findByBrand(brand, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(car);
        }
    }

    /**
     * Returns the number of cars where brand = &#63;.
     *
     * @param brand the brand
     * @return the number of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByBrand(String brand) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BRAND;

        Object[] finderArgs = new Object[] { brand };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CAR_WHERE);

            boolean bindBrand = false;

            if (brand == null) {
                query.append(_FINDER_COLUMN_BRAND_BRAND_1);
            } else if (brand.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BRAND_BRAND_3);
            } else {
                bindBrand = true;

                query.append(_FINDER_COLUMN_BRAND_BRAND_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindBrand) {
                    qPos.add(brand);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the cars where model = &#63;.
     *
     * @param model the model
     * @return the matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByModel(String model) throws SystemException {
        return findByModel(model, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the cars where model = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param model the model
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @return the range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByModel(String model, int start, int end)
        throws SystemException {
        return findByModel(model, start, end, null);
    }

    /**
     * Returns an ordered range of all the cars where model = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param model the model
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findByModel(String model, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODEL;
            finderArgs = new Object[] { model };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODEL;
            finderArgs = new Object[] { model, start, end, orderByComparator };
        }

        List<Car> list = (List<Car>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Car car : list) {
                if (!Validator.equals(model, car.getModel())) {
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
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CAR_WHERE);

            boolean bindModel = false;

            if (model == null) {
                query.append(_FINDER_COLUMN_MODEL_MODEL_1);
            } else if (model.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MODEL_MODEL_3);
            } else {
                bindModel = true;

                query.append(_FINDER_COLUMN_MODEL_MODEL_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CarModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindModel) {
                    qPos.add(model);
                }

                if (!pagination) {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Car>(list);
                } else {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first car in the ordered set where model = &#63;.
     *
     * @param model the model
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByModel_First(String model,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByModel_First(model, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("model=");
        msg.append(model);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the first car in the ordered set where model = &#63;.
     *
     * @param model the model
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByModel_First(String model,
        OrderByComparator orderByComparator) throws SystemException {
        List<Car> list = findByModel(model, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last car in the ordered set where model = &#63;.
     *
     * @param model the model
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car
     * @throws com.rental.car.NoSuchCarException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByModel_Last(String model,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = fetchByModel_Last(model, orderByComparator);

        if (car != null) {
            return car;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("model=");
        msg.append(model);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCarException(msg.toString());
    }

    /**
     * Returns the last car in the ordered set where model = &#63;.
     *
     * @param model the model
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByModel_Last(String model,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByModel(model);

        if (count == 0) {
            return null;
        }

        List<Car> list = findByModel(model, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the cars before and after the current car in the ordered set where model = &#63;.
     *
     * @param carId the primary key of the current car
     * @param model the model
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next car
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car[] findByModel_PrevAndNext(long carId, String model,
        OrderByComparator orderByComparator)
        throws NoSuchCarException, SystemException {
        Car car = findByPrimaryKey(carId);

        Session session = null;

        try {
            session = openSession();

            Car[] array = new CarImpl[3];

            array[0] = getByModel_PrevAndNext(session, car, model,
                    orderByComparator, true);

            array[1] = car;

            array[2] = getByModel_PrevAndNext(session, car, model,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Car getByModel_PrevAndNext(Session session, Car car,
        String model, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CAR_WHERE);

        boolean bindModel = false;

        if (model == null) {
            query.append(_FINDER_COLUMN_MODEL_MODEL_1);
        } else if (model.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_MODEL_MODEL_3);
        } else {
            bindModel = true;

            query.append(_FINDER_COLUMN_MODEL_MODEL_2);
        }

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CarModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindModel) {
            qPos.add(model);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(car);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Car> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the cars where model = &#63; from the database.
     *
     * @param model the model
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByModel(String model) throws SystemException {
        for (Car car : findByModel(model, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(car);
        }
    }

    /**
     * Returns the number of cars where model = &#63;.
     *
     * @param model the model
     * @return the number of matching cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModel(String model) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODEL;

        Object[] finderArgs = new Object[] { model };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CAR_WHERE);

            boolean bindModel = false;

            if (model == null) {
                query.append(_FINDER_COLUMN_MODEL_MODEL_1);
            } else if (model.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MODEL_MODEL_3);
            } else {
                bindModel = true;

                query.append(_FINDER_COLUMN_MODEL_MODEL_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindModel) {
                    qPos.add(model);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the car in the entity cache if it is enabled.
     *
     * @param car the car
     */
    @Override
    public void cacheResult(Car car) {
        EntityCacheUtil.putResult(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarImpl.class, car.getPrimaryKey(), car);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { car.getUuid(), car.getGroupId() }, car);

        car.resetOriginalValues();
    }

    /**
     * Caches the cars in the entity cache if it is enabled.
     *
     * @param cars the cars
     */
    @Override
    public void cacheResult(List<Car> cars) {
        for (Car car : cars) {
            if (EntityCacheUtil.getResult(CarModelImpl.ENTITY_CACHE_ENABLED,
                        CarImpl.class, car.getPrimaryKey()) == null) {
                cacheResult(car);
            } else {
                car.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all cars.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CarImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CarImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the car.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Car car) {
        EntityCacheUtil.removeResult(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarImpl.class, car.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(car);
    }

    @Override
    public void clearCache(List<Car> cars) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Car car : cars) {
            EntityCacheUtil.removeResult(CarModelImpl.ENTITY_CACHE_ENABLED,
                CarImpl.class, car.getPrimaryKey());

            clearUniqueFindersCache(car);
        }
    }

    protected void cacheUniqueFindersCache(Car car) {
        if (car.isNew()) {
            Object[] args = new Object[] { car.getUuid(), car.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, car);
        } else {
            CarModelImpl carModelImpl = (CarModelImpl) car;

            if ((carModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { car.getUuid(), car.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, car);
            }
        }
    }

    protected void clearUniqueFindersCache(Car car) {
        CarModelImpl carModelImpl = (CarModelImpl) car;

        Object[] args = new Object[] { car.getUuid(), car.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((carModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    carModelImpl.getOriginalUuid(),
                    carModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new car with the primary key. Does not add the car to the database.
     *
     * @param carId the primary key for the new car
     * @return the new car
     */
    @Override
    public Car create(long carId) {
        Car car = new CarImpl();

        car.setNew(true);
        car.setPrimaryKey(carId);

        String uuid = PortalUUIDUtil.generate();

        car.setUuid(uuid);

        return car;
    }

    /**
     * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param carId the primary key of the car
     * @return the car that was removed
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car remove(long carId) throws NoSuchCarException, SystemException {
        return remove((Serializable) carId);
    }

    /**
     * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the car
     * @return the car that was removed
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car remove(Serializable primaryKey)
        throws NoSuchCarException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Car car = (Car) session.get(CarImpl.class, primaryKey);

            if (car == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(car);
        } catch (NoSuchCarException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Car removeImpl(Car car) throws SystemException {
        car = toUnwrappedModel(car);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(car)) {
                car = (Car) session.get(CarImpl.class, car.getPrimaryKeyObj());
            }

            if (car != null) {
                session.delete(car);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (car != null) {
            clearCache(car);
        }

        return car;
    }

    @Override
    public Car updateImpl(com.rental.car.model.Car car)
        throws SystemException {
        car = toUnwrappedModel(car);

        boolean isNew = car.isNew();

        CarModelImpl carModelImpl = (CarModelImpl) car;

        if (Validator.isNull(car.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            car.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (car.isNew()) {
                session.save(car);

                car.setNew(false);
            } else {
                session.merge(car);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CarModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((carModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { carModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { carModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((carModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        carModelImpl.getOriginalUuid(),
                        carModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        carModelImpl.getUuid(), carModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((carModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { carModelImpl.getOriginalBrand() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRAND, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND,
                    args);

                args = new Object[] { carModelImpl.getBrand() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRAND, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND,
                    args);
            }

            if ((carModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODEL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { carModelImpl.getOriginalModel() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODEL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODEL,
                    args);

                args = new Object[] { carModelImpl.getModel() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODEL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODEL,
                    args);
            }
        }

        EntityCacheUtil.putResult(CarModelImpl.ENTITY_CACHE_ENABLED,
            CarImpl.class, car.getPrimaryKey(), car);

        clearUniqueFindersCache(car);
        cacheUniqueFindersCache(car);

        return car;
    }

    protected Car toUnwrappedModel(Car car) {
        if (car instanceof CarImpl) {
            return car;
        }

        CarImpl carImpl = new CarImpl();

        carImpl.setNew(car.isNew());
        carImpl.setPrimaryKey(car.getPrimaryKey());

        carImpl.setUuid(car.getUuid());
        carImpl.setCarId(car.getCarId());
        carImpl.setGroupId(car.getGroupId());
        carImpl.setCompanyId(car.getCompanyId());
        carImpl.setUserId(car.getUserId());
        carImpl.setUserName(car.getUserName());
        carImpl.setCreateDate(car.getCreateDate());
        carImpl.setModifiedDate(car.getModifiedDate());
        carImpl.setStatus(car.getStatus());
        carImpl.setStatusByUserId(car.getStatusByUserId());
        carImpl.setStatusByUserName(car.getStatusByUserName());
        carImpl.setStatusDate(car.getStatusDate());
        carImpl.setBrand(car.getBrand());
        carImpl.setModel(car.getModel());
        carImpl.setManufacturingYear(car.getManufacturingYear());
        carImpl.setFuelType(car.getFuelType());
        carImpl.setPassengers(car.getPassengers());

        return carImpl;
    }

    /**
     * Returns the car with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the car
     * @return the car
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCarException, SystemException {
        Car car = fetchByPrimaryKey(primaryKey);

        if (car == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return car;
    }

    /**
     * Returns the car with the primary key or throws a {@link com.rental.car.NoSuchCarException} if it could not be found.
     *
     * @param carId the primary key of the car
     * @return the car
     * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car findByPrimaryKey(long carId)
        throws NoSuchCarException, SystemException {
        return findByPrimaryKey((Serializable) carId);
    }

    /**
     * Returns the car with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the car
     * @return the car, or <code>null</code> if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Car car = (Car) EntityCacheUtil.getResult(CarModelImpl.ENTITY_CACHE_ENABLED,
                CarImpl.class, primaryKey);

        if (car == _nullCar) {
            return null;
        }

        if (car == null) {
            Session session = null;

            try {
                session = openSession();

                car = (Car) session.get(CarImpl.class, primaryKey);

                if (car != null) {
                    cacheResult(car);
                } else {
                    EntityCacheUtil.putResult(CarModelImpl.ENTITY_CACHE_ENABLED,
                        CarImpl.class, primaryKey, _nullCar);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CarModelImpl.ENTITY_CACHE_ENABLED,
                    CarImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return car;
    }

    /**
     * Returns the car with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param carId the primary key of the car
     * @return the car, or <code>null</code> if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchByPrimaryKey(long carId) throws SystemException {
        return fetchByPrimaryKey((Serializable) carId);
    }

    /**
     * Returns all the cars.
     *
     * @return the cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the cars.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @return the range of cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the cars.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of cars
     * @param end the upper bound of the range of cars (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Car> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Car> list = (List<Car>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CAR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CAR;

                if (pagination) {
                    sql = sql.concat(CarModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Car>(list);
                } else {
                    list = (List<Car>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the cars from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Car car : findAll()) {
            remove(car);
        }
    }

    /**
     * Returns the number of cars.
     *
     * @return the number of cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CAR);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the car persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.rental.car.model.Car")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Car>> listenersList = new ArrayList<ModelListener<Car>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Car>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CarImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

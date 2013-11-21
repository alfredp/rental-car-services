package com.rental.car.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rental.car.model.Car;

import java.util.List;

/**
 * The persistence utility for the car service. This utility wraps {@link CarPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarPersistence
 * @see CarPersistenceImpl
 * @generated
 */
public class CarUtil {
    private static CarPersistence _persistence;

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
    public static void clearCache(Car car) {
        getPersistence().clearCache(car);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Car update(Car car, boolean merge) throws SystemException {
        return getPersistence().update(car, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Car update(Car car, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(car, merge, serviceContext);
    }

    /**
    * Caches the car in the entity cache if it is enabled.
    *
    * @param car the car
    */
    public static void cacheResult(com.rental.car.model.Car car) {
        getPersistence().cacheResult(car);
    }

    /**
    * Caches the cars in the entity cache if it is enabled.
    *
    * @param cars the cars
    */
    public static void cacheResult(
        java.util.List<com.rental.car.model.Car> cars) {
        getPersistence().cacheResult(cars);
    }

    /**
    * Creates a new car with the primary key. Does not add the car to the database.
    *
    * @param carId the primary key for the new car
    * @return the new car
    */
    public static com.rental.car.model.Car create(long carId) {
        return getPersistence().create(carId);
    }

    /**
    * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param carId the primary key of the car
    * @return the car that was removed
    * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car remove(long carId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().remove(carId);
    }

    public static com.rental.car.model.Car updateImpl(
        com.rental.car.model.Car car, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(car, merge);
    }

    /**
    * Returns the car with the primary key or throws a {@link com.rental.car.NoSuchCarException} if it could not be found.
    *
    * @param carId the primary key of the car
    * @return the car
    * @throws com.rental.car.NoSuchCarException if a car with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car findByPrimaryKey(long carId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByPrimaryKey(carId);
    }

    /**
    * Returns the car with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param carId the primary key of the car
    * @return the car, or <code>null</code> if a car with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByPrimaryKey(long carId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(carId);
    }

    /**
    * Returns all the cars where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the cars where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @return the range of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the cars where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
    public static com.rental.car.model.Car findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first car in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
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
    public static com.rental.car.model.Car findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last car in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
    public static com.rental.car.model.Car[] findByUuid_PrevAndNext(
        long carId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence()
                   .findByUuid_PrevAndNext(carId, uuid, orderByComparator);
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
    public static com.rental.car.model.Car findByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the car where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
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
    public static com.rental.car.model.Car fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Returns all the cars where brand = &#63;.
    *
    * @param brand the brand
    * @return the matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByBrand(
        java.lang.String brand)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrand(brand);
    }

    /**
    * Returns a range of all the cars where brand = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param brand the brand
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @return the range of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByBrand(
        java.lang.String brand, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrand(brand, start, end);
    }

    /**
    * Returns an ordered range of all the cars where brand = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param brand the brand
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByBrand(
        java.lang.String brand, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrand(brand, start, end, orderByComparator);
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
    public static com.rental.car.model.Car findByBrand_First(
        java.lang.String brand,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByBrand_First(brand, orderByComparator);
    }

    /**
    * Returns the first car in the ordered set where brand = &#63;.
    *
    * @param brand the brand
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByBrand_First(
        java.lang.String brand,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByBrand_First(brand, orderByComparator);
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
    public static com.rental.car.model.Car findByBrand_Last(
        java.lang.String brand,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByBrand_Last(brand, orderByComparator);
    }

    /**
    * Returns the last car in the ordered set where brand = &#63;.
    *
    * @param brand the brand
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByBrand_Last(
        java.lang.String brand,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByBrand_Last(brand, orderByComparator);
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
    public static com.rental.car.model.Car[] findByBrand_PrevAndNext(
        long carId, java.lang.String brand,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence()
                   .findByBrand_PrevAndNext(carId, brand, orderByComparator);
    }

    /**
    * Returns all the cars where model = &#63;.
    *
    * @param model the model
    * @return the matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByModel(
        java.lang.String model)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModel(model);
    }

    /**
    * Returns a range of all the cars where model = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param model the model
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @return the range of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByModel(
        java.lang.String model, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModel(model, start, end);
    }

    /**
    * Returns an ordered range of all the cars where model = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param model the model
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findByModel(
        java.lang.String model, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModel(model, start, end, orderByComparator);
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
    public static com.rental.car.model.Car findByModel_First(
        java.lang.String model,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByModel_First(model, orderByComparator);
    }

    /**
    * Returns the first car in the ordered set where model = &#63;.
    *
    * @param model the model
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByModel_First(
        java.lang.String model,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByModel_First(model, orderByComparator);
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
    public static com.rental.car.model.Car findByModel_Last(
        java.lang.String model,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().findByModel_Last(model, orderByComparator);
    }

    /**
    * Returns the last car in the ordered set where model = &#63;.
    *
    * @param model the model
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching car, or <code>null</code> if a matching car could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car fetchByModel_Last(
        java.lang.String model,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByModel_Last(model, orderByComparator);
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
    public static com.rental.car.model.Car[] findByModel_PrevAndNext(
        long carId, java.lang.String model,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence()
                   .findByModel_PrevAndNext(carId, model, orderByComparator);
    }

    /**
    * Returns all the cars.
    *
    * @return the cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the cars.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @return the range of cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the cars.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of cars
    * @param end the upper bound of the range of cars (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of cars
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.rental.car.model.Car> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the cars where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Removes the car where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the car that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.rental.car.model.Car removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.rental.car.NoSuchCarException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Removes all the cars where brand = &#63; from the database.
    *
    * @param brand the brand
    * @throws SystemException if a system exception occurred
    */
    public static void removeByBrand(java.lang.String brand)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByBrand(brand);
    }

    /**
    * Removes all the cars where model = &#63; from the database.
    *
    * @param model the model
    * @throws SystemException if a system exception occurred
    */
    public static void removeByModel(java.lang.String model)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByModel(model);
    }

    /**
    * Removes all the cars from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of cars where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the number of cars where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of cars where brand = &#63;.
    *
    * @param brand the brand
    * @return the number of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static int countByBrand(java.lang.String brand)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByBrand(brand);
    }

    /**
    * Returns the number of cars where model = &#63;.
    *
    * @param model the model
    * @return the number of matching cars
    * @throws SystemException if a system exception occurred
    */
    public static int countByModel(java.lang.String model)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByModel(model);
    }

    /**
    * Returns the number of cars.
    *
    * @return the number of cars
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CarPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CarPersistence) PortletBeanLocatorUtil.locate(com.rental.car.service.ClpSerializer.getServletContextName(),
                    CarPersistence.class.getName());

            ReferenceRegistry.registerReference(CarUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(CarPersistence persistence) {
    }
}

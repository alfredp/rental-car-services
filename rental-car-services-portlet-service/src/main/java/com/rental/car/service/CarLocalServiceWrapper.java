package com.rental.car.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CarLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CarLocalService
 * @generated
 */
public class CarLocalServiceWrapper implements CarLocalService,
    ServiceWrapper<CarLocalService> {
    private CarLocalService _carLocalService;

    public CarLocalServiceWrapper(CarLocalService carLocalService) {
        _carLocalService = carLocalService;
    }

    /**
    * Adds the car to the database. Also notifies the appropriate model listeners.
    *
    * @param car the car
    * @return the car that was added
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car addCar(com.rental.car.model.Car car)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.addCar(car);
    }

    /**
    * Creates a new car with the primary key. Does not add the car to the database.
    *
    * @param carId the primary key for the new car
    * @return the new car
    */
    public com.rental.car.model.Car createCar(long carId) {
        return _carLocalService.createCar(carId);
    }

    /**
    * Deletes the car with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param carId the primary key of the car
    * @return the car that was removed
    * @throws PortalException if a car with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car deleteCar(long carId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.deleteCar(carId);
    }

    /**
    * Deletes the car from the database. Also notifies the appropriate model listeners.
    *
    * @param car the car
    * @return the car that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car deleteCar(com.rental.car.model.Car car)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.deleteCar(car);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _carLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.rental.car.model.Car fetchCar(long carId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.fetchCar(carId);
    }

    /**
    * Returns the car with the primary key.
    *
    * @param carId the primary key of the car
    * @return the car
    * @throws PortalException if a car with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car getCar(long carId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.getCar(carId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the car with the UUID in the group.
    *
    * @param uuid the UUID of car
    * @param groupId the group id of the car
    * @return the car
    * @throws PortalException if a car with the UUID in the group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car getCarByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.getCarByUuidAndGroupId(uuid, groupId);
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
    public java.util.List<com.rental.car.model.Car> getCars(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.getCars(start, end);
    }

    /**
    * Returns the number of cars.
    *
    * @return the number of cars
    * @throws SystemException if a system exception occurred
    */
    public int getCarsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.getCarsCount();
    }

    /**
    * Updates the car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param car the car
    * @return the car that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car updateCar(com.rental.car.model.Car car)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.updateCar(car);
    }

    /**
    * Updates the car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param car the car
    * @param merge whether to merge the car with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the car that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.rental.car.model.Car updateCar(com.rental.car.model.Car car,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.updateCar(car, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _carLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _carLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _carLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public com.rental.car.model.Car addCar(java.lang.String brand,
        java.lang.String model, java.util.Date manufacturingYear,
        java.lang.String fuelType, int passengers,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.addCar(brand, model, manufacturingYear,
            fuelType, passengers, serviceContext);
    }

    public com.rental.car.model.Car updateCar(long carId,
        java.lang.String brand, java.lang.String model,
        java.util.Date manufacturingYear, java.lang.String fuelType,
        int passengers, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _carLocalService.updateCar(carId, brand, model,
            manufacturingYear, fuelType, passengers, serviceContext);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public CarLocalService getWrappedCarLocalService() {
        return _carLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedCarLocalService(CarLocalService carLocalService) {
        _carLocalService = carLocalService;
    }

    public CarLocalService getWrappedService() {
        return _carLocalService;
    }

    public void setWrappedService(CarLocalService carLocalService) {
        _carLocalService = carLocalService;
    }
}

package com.rental.car.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import com.rental.car.model.Car;
import com.rental.car.service.CarLocalService;
import com.rental.car.service.persistence.CarPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the car local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rental.car.service.impl.CarLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rental.car.service.impl.CarLocalServiceImpl
 * @see com.rental.car.service.CarLocalServiceUtil
 * @generated
 */
public abstract class CarLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements CarLocalService, IdentifiableBean {
    @BeanReference(type = com.rental.car.service.CarLocalService.class)
    protected com.rental.car.service.CarLocalService carLocalService;
    @BeanReference(type = com.rental.car.service.CarService.class)
    protected com.rental.car.service.CarService carService;
    @BeanReference(type = CarPersistence.class)
    protected CarPersistence carPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portal.service.WorkflowInstanceLinkLocalService.class)
    protected com.liferay.portal.service.WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
    @BeanReference(type = WorkflowInstanceLinkPersistence.class)
    protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
    protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
    protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private CarLocalServiceClpInvoker _clpInvoker = new CarLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.rental.car.service.CarLocalServiceUtil} to access the car local service.
     */

    /**
     * Adds the car to the database. Also notifies the appropriate model listeners.
     *
     * @param car the car
     * @return the car that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Car addCar(Car car) throws SystemException {
        car.setNew(true);

        return carPersistence.update(car);
    }

    /**
     * Creates a new car with the primary key. Does not add the car to the database.
     *
     * @param carId the primary key for the new car
     * @return the new car
     */
    @Override
    public Car createCar(long carId) {
        return carPersistence.create(carId);
    }

    /**
     * Deletes the car with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param carId the primary key of the car
     * @return the car that was removed
     * @throws PortalException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Car deleteCar(long carId) throws PortalException, SystemException {
        return carPersistence.remove(carId);
    }

    /**
     * Deletes the car from the database. Also notifies the appropriate model listeners.
     *
     * @param car the car
     * @return the car that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Car deleteCar(Car car) throws SystemException {
        return carPersistence.remove(car);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Car.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return carPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return carPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rental.car.model.impl.CarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return carPersistence.findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return carPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return carPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Car fetchCar(long carId) throws SystemException {
        return carPersistence.fetchByPrimaryKey(carId);
    }

    /**
     * Returns the car with the matching UUID and company.
     *
     * @param uuid the car's UUID
     * @param  companyId the primary key of the company
     * @return the matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchCarByUuidAndCompanyId(String uuid, long companyId)
        throws SystemException {
        return carPersistence.fetchByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the car matching the UUID and group.
     *
     * @param uuid the car's UUID
     * @param groupId the primary key of the group
     * @return the matching car, or <code>null</code> if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car fetchCarByUuidAndGroupId(String uuid, long groupId)
        throws SystemException {
        return carPersistence.fetchByUUID_G(uuid, groupId);
    }

    /**
     * Returns the car with the primary key.
     *
     * @param carId the primary key of the car
     * @return the car
     * @throws PortalException if a car with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car getCar(long carId) throws PortalException, SystemException {
        return carPersistence.findByPrimaryKey(carId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return carPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns the car with the matching UUID and company.
     *
     * @param uuid the car's UUID
     * @param  companyId the primary key of the company
     * @return the matching car
     * @throws PortalException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car getCarByUuidAndCompanyId(String uuid, long companyId)
        throws PortalException, SystemException {
        return carPersistence.findByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the car matching the UUID and group.
     *
     * @param uuid the car's UUID
     * @param groupId the primary key of the group
     * @return the matching car
     * @throws PortalException if a matching car could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Car getCarByUuidAndGroupId(String uuid, long groupId)
        throws PortalException, SystemException {
        return carPersistence.findByUUID_G(uuid, groupId);
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
    public List<Car> getCars(int start, int end) throws SystemException {
        return carPersistence.findAll(start, end);
    }

    /**
     * Returns the number of cars.
     *
     * @return the number of cars
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getCarsCount() throws SystemException {
        return carPersistence.countAll();
    }

    /**
     * Updates the car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param car the car
     * @return the car that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Car updateCar(Car car) throws SystemException {
        return carPersistence.update(car);
    }

    /**
     * Returns the car local service.
     *
     * @return the car local service
     */
    public com.rental.car.service.CarLocalService getCarLocalService() {
        return carLocalService;
    }

    /**
     * Sets the car local service.
     *
     * @param carLocalService the car local service
     */
    public void setCarLocalService(
        com.rental.car.service.CarLocalService carLocalService) {
        this.carLocalService = carLocalService;
    }

    /**
     * Returns the car remote service.
     *
     * @return the car remote service
     */
    public com.rental.car.service.CarService getCarService() {
        return carService;
    }

    /**
     * Sets the car remote service.
     *
     * @param carService the car remote service
     */
    public void setCarService(com.rental.car.service.CarService carService) {
        this.carService = carService;
    }

    /**
     * Returns the car persistence.
     *
     * @return the car persistence
     */
    public CarPersistence getCarPersistence() {
        return carPersistence;
    }

    /**
     * Sets the car persistence.
     *
     * @param carPersistence the car persistence
     */
    public void setCarPersistence(CarPersistence carPersistence) {
        this.carPersistence = carPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the workflow instance link local service.
     *
     * @return the workflow instance link local service
     */
    public com.liferay.portal.service.WorkflowInstanceLinkLocalService getWorkflowInstanceLinkLocalService() {
        return workflowInstanceLinkLocalService;
    }

    /**
     * Sets the workflow instance link local service.
     *
     * @param workflowInstanceLinkLocalService the workflow instance link local service
     */
    public void setWorkflowInstanceLinkLocalService(
        com.liferay.portal.service.WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
        this.workflowInstanceLinkLocalService = workflowInstanceLinkLocalService;
    }

    /**
     * Returns the workflow instance link persistence.
     *
     * @return the workflow instance link persistence
     */
    public WorkflowInstanceLinkPersistence getWorkflowInstanceLinkPersistence() {
        return workflowInstanceLinkPersistence;
    }

    /**
     * Sets the workflow instance link persistence.
     *
     * @param workflowInstanceLinkPersistence the workflow instance link persistence
     */
    public void setWorkflowInstanceLinkPersistence(
        WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence) {
        this.workflowInstanceLinkPersistence = workflowInstanceLinkPersistence;
    }

    /**
     * Returns the asset entry local service.
     *
     * @return the asset entry local service
     */
    public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(
        com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
        this.assetEntryService = assetEntryService;
    }

    /**
     * Returns the asset entry persistence.
     *
     * @return the asset entry persistence
     */
    public AssetEntryPersistence getAssetEntryPersistence() {
        return assetEntryPersistence;
    }

    /**
     * Sets the asset entry persistence.
     *
     * @param assetEntryPersistence the asset entry persistence
     */
    public void setAssetEntryPersistence(
        AssetEntryPersistence assetEntryPersistence) {
        this.assetEntryPersistence = assetEntryPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.rental.car.model.Car",
            carLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.rental.car.model.Car");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Car.class;
    }

    protected String getModelClassName() {
        return Car.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = carPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}

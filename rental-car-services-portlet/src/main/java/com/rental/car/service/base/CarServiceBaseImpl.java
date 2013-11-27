package com.rental.car.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;

import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.asset.service.AssetEntryService;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import com.rental.car.model.Car;
import com.rental.car.service.CarLocalService;
import com.rental.car.service.CarService;
import com.rental.car.service.persistence.CarPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the car remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rental.car.service.impl.CarServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rental.car.service.impl.CarServiceImpl
 * @see com.rental.car.service.CarServiceUtil
 * @generated
 */
public abstract class CarServiceBaseImpl extends BaseServiceImpl
    implements CarService, IdentifiableBean {
    @BeanReference(type = CarLocalService.class)
    protected CarLocalService carLocalService;
    @BeanReference(type = CarService.class)
    protected CarService carService;
    @BeanReference(type = CarPersistence.class)
    protected CarPersistence carPersistence;
    @BeanReference(type = CounterLocalService.class)
    protected CounterLocalService counterLocalService;
    @BeanReference(type = ResourceLocalService.class)
    protected ResourceLocalService resourceLocalService;
    @BeanReference(type = ResourceService.class)
    protected ResourceService resourceService;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserLocalService.class)
    protected UserLocalService userLocalService;
    @BeanReference(type = UserService.class)
    protected UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = WorkflowInstanceLinkLocalService.class)
    protected WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
    @BeanReference(type = WorkflowInstanceLinkPersistence.class)
    protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
    @BeanReference(type = AssetEntryLocalService.class)
    protected AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = AssetEntryService.class)
    protected AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    private String _beanIdentifier;
    private CarServiceClpInvoker _clpInvoker = new CarServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.rental.car.service.CarServiceUtil} to access the car remote service.
     */

    /**
     * Returns the car local service.
     *
     * @return the car local service
     */
    public CarLocalService getCarLocalService() {
        return carLocalService;
    }

    /**
     * Sets the car local service.
     *
     * @param carLocalService the car local service
     */
    public void setCarLocalService(CarLocalService carLocalService) {
        this.carLocalService = carLocalService;
    }

    /**
     * Returns the car remote service.
     *
     * @return the car remote service
     */
    public CarService getCarService() {
        return carService;
    }

    /**
     * Sets the car remote service.
     *
     * @param carService the car remote service
     */
    public void setCarService(CarService carService) {
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
    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the resource remote service.
     *
     * @return the resource remote service
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Sets the resource remote service.
     *
     * @param resourceService the resource remote service
     */
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Returns the resource persistence.
     *
     * @return the resource persistence
     */
    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    /**
     * Sets the resource persistence.
     *
     * @param resourcePersistence the resource persistence
     */
    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(UserService userService) {
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
    public WorkflowInstanceLinkLocalService getWorkflowInstanceLinkLocalService() {
        return workflowInstanceLinkLocalService;
    }

    /**
     * Sets the workflow instance link local service.
     *
     * @param workflowInstanceLinkLocalService the workflow instance link local service
     */
    public void setWorkflowInstanceLinkLocalService(
        WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
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
    public AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(AssetEntryService assetEntryService) {
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
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
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
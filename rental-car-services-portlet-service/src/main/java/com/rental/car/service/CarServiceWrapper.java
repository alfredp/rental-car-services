package com.rental.car.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CarService}.
 *
 * @author Brian Wing Shun Chan
 * @see CarService
 * @generated
 */
public class CarServiceWrapper implements CarService,
    ServiceWrapper<CarService> {
    private CarService _carService;

    public CarServiceWrapper(CarService carService) {
        _carService = carService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _carService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _carService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _carService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CarService getWrappedCarService() {
        return _carService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCarService(CarService carService) {
        _carService = carService;
    }

    @Override
    public CarService getWrappedService() {
        return _carService;
    }

    @Override
    public void setWrappedService(CarService carService) {
        _carService = carService;
    }
}

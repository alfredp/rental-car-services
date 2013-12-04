package com.rental.car.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.rental.car.model.Car;
import com.rental.car.service.CarLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CarActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CarActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CarLocalServiceUtil.getService());
        setClass(Car.class);

        setClassLoader(com.rental.car.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("carId");
    }
}

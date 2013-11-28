package com.rental.car.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.rental.car.model.Car;
import com.rental.car.service.base.CarLocalServiceBaseImpl;

/**
 * The implementation of the car local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rental.car.service.CarLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rental.car.service.base.CarLocalServiceBaseImpl
 * @see com.rental.car.service.CarLocalServiceUtil
 */
public class CarLocalServiceImpl extends CarLocalServiceBaseImpl {

	public Car addCar(
			final String brand, 
			final String model,
			final Date manufacturingYear,
			final String fuelType,
			final int passengers,
			final ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		validateCar(brand, model, manufacturingYear, fuelType, passengers);
		
		final User user = userLocalService.getUser(serviceContext.getUserId());
		final long carId = counterLocalService.increment(Car.class.getName());
		final Car car = carPersistence.create(carId);
		
		car.setBrand(brand);
		car.setModel(model);
		car.setManufacturingYear(manufacturingYear);
		car.setFuelType(fuelType);
		car.setPassengers(passengers);
		
		car.setStatus(WorkflowConstants.STATUS_DRAFT);
		car.setStatusByUserId(user.getUserId());
		car.setStatusDate(new Date());
		
		carPersistence.update(car, false);
		
		WorkflowHandlerRegistryUtil
			.startWorkflowInstance(
				car.getCompanyId(),
				car.getGroupId(),
				car.getUserId(),
				Car.class.getName(),
				car.getPrimaryKey(),
				car,
				serviceContext);
		
		return car;
		
	}
	
	public Car updateCar(
			final long carId,
			final String brand, 
			final String model,
			final Date manufacturingYear,
			final String fuelType,
			final int passengers,
			final ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		return null;
		
//		validateCar(brand, model, manufacturingYear, fuelType, passengers);
//		
//		final User user = userLocalService.getUser(serviceContext.getUserId());
//		final Car car = carLocalService.getCar(carId);
//		
//		car.setBrand(brand);
//		car.setModel(model);
//		car.setManufacturingYear(manufacturingYear);
//		car.setFuelType(fuelType);
//		car.setPassengers(passengers);
//		
//		car.setStatus(WorkflowConstants.STATUS_DRAFT);
//		car.setStatusByUserId(user.getUserId());
//		car.setStatusDate(new Date());
//		
//		carPersistence.update(car, false);
//		
//		WorkflowHandlerRegistryUtil
//			.startWorkflowInstance(
//				car.getCompanyId(),
//				car.getGroupId(),
//				car.getUserId(),
//				Car.class.getName(),
//				car.getPrimaryKey(),
//				car,
//				serviceContext);
//		
//		return car;
		
	}

	protected void validateCar(
			final String brand, 
			final String model, 
			final Date manufacturingYear,
			final String fuelType, 
			final int passengers) {
		
		if (Validator.isNull(brand)) {
			throw new IllegalArgumentException("Parameter brand cannot be null or empty!");
		}
		
		if (Validator.isNull(model)) {
			throw new IllegalArgumentException("Parameter model cannot be null or empty!");
		}
		
		if (Validator.isNull(manufacturingYear)) {
			throw new IllegalArgumentException("Parameter manufacturingYear cannot be null or empty!");
		}
		
		if (Validator.isNull(fuelType)) {
			throw new IllegalArgumentException("Parameter fuelType cannot be null or empty!");
		}
		
		if (Validator.isNull(passengers)) {
			throw new IllegalArgumentException("Parameter passengers cannot be null or empty!");
		}
		else if (passengers < 0) {
			throw new IllegalArgumentException("Parameter passengers cannot be negative!");
		}
		
	}

}

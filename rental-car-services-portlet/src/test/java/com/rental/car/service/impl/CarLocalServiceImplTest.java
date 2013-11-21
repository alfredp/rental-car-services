package com.rental.car.service.impl;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.rental.car.model.Car;
import com.rental.car.model.CarClp;
import com.rental.car.service.CarLocalService;
import com.rental.car.service.persistence.CarPersistence;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { WorkflowHandlerRegistryUtil.class } )
public class CarLocalServiceImplTest {
	
	@Rule
	protected ExpectedException expectedEx = ExpectedException.none();

	@Test(expected = IllegalArgumentException.class)
	public void testCarWithEmptyBrand() throws Exception {
		
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Parameter model cannot be null or empty!");
		
		String brand = StringPool.BLANK;
		String model = "model";
		Date manufacturingYear = new Date();
		String fuelType = "fuel";
		int passengers = 2;
		ServiceContext serviceContext = new ServiceContext();
		CarLocalService service = new CarLocalServiceImpl();

		service.addCar(brand, model, manufacturingYear, fuelType, passengers, serviceContext);
		
	}
	
	@Test
	public void testCarWithNullBrand() throws Exception {
		
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Parameter brand cannot be null or empty!");
		
		String brand = null;
		String model = "model";
		Date manufacturingYear = new Date();
		String fuelType = "fuel";
		int passengers = 2;
		ServiceContext serviceContext = new ServiceContext();
		CarLocalService service = new CarLocalServiceImpl();

		service.addCar(brand, model, manufacturingYear, fuelType, passengers, serviceContext);
		
	}
	
	@Test
	public void testCarWithNullManufacturingYear() throws Exception {
		
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Parameter manufacturingYear cannot be null or empty!");
		
		String brand = "brand";
		String model = "model";
		Date manufacturingYear = null;
		String fuelType = "fuel";
		int passengers = 2;
		ServiceContext serviceContext = new ServiceContext();
		CarLocalService service = new CarLocalServiceImpl();

		service.addCar(brand, model, manufacturingYear, fuelType, passengers, serviceContext);
		
	}
	
	@Test
	public void testAddCar() throws Exception {
		
		String brand = "brand";
		String model = "model";
		Date manufacturingYear = new Date();
		String fuelType = "fuel";
		int passengers = 2;
		long carId = 1000l;
		
		ServiceContext serviceContext = new ServiceContext();
		CarLocalServiceImpl service = new CarLocalServiceImpl();
		
		// Mock!
		
		User userMock = createNiceMock(User.class);
		expect(userMock.getUserId()).andReturn(serviceContext.getUserId());
		replay(userMock);

		UserLocalService userLocalServiceMock = createNiceMock(UserLocalService.class);

		expect(userLocalServiceMock.getUser(serviceContext.getUserId())).andReturn(userMock);
		replay(userLocalServiceMock);

		service.setUserLocalService(userLocalServiceMock);

		CounterLocalService counterLocalServiceMock = createNiceMock(CounterLocalService.class);

		expect(counterLocalServiceMock.increment(Car.class.getName())).andReturn(carId);
		replay(counterLocalServiceMock);

		service.setCounterLocalService(counterLocalServiceMock);
		
		Car carMock = new CarClp();
		carMock.setCarId(carId);
		carMock.setBrand(brand);
		carMock.setModel(model);
		carMock.setManufacturingYear(manufacturingYear);
		carMock.setFuelType(fuelType);
		carMock.setPassengers(passengers);
		
		CarPersistence carPersistenceMock = createNiceMock(CarPersistence.class);

		expect(carPersistenceMock.create(carId)).andReturn(carMock);
		replay(carPersistenceMock);
		
		service.setCarPersistence(carPersistenceMock);
		
		PowerMock.mockStatic(WorkflowHandlerRegistryUtil.class);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			carMock.getCompanyId(), carMock.getGroupId(),
			carMock.getUserId(), Car.class.getName(),
			carMock.getPrimaryKey(), carMock, serviceContext);

		PowerMock.replay(WorkflowHandlerRegistryUtil.class);
		
		// Test
		
		Car car = service.addCar(brand, model, manufacturingYear, fuelType, passengers, serviceContext);

		assertNotNull(car);
		assertEquals(carId, car.getCarId());
		assertEquals(brand, car.getBrand());
		assertEquals(model, car.getModel());
		assertEquals(manufacturingYear, car.getManufacturingYear());
		assertEquals(fuelType, car.getFuelType());
		assertEquals(passengers, car.getPassengers());
		
		assertEquals(WorkflowConstants.STATUS_DRAFT, car.getStatus());

		verify(userMock, userLocalServiceMock, counterLocalServiceMock, carPersistenceMock);
		
	}
	
}

package com.rental.car.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Car}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Car
 * @generated
 */
public class CarWrapper implements Car, ModelWrapper<Car> {
    private Car _car;

    public CarWrapper(Car car) {
        _car = car;
    }

    @Override
    public Class<?> getModelClass() {
        return Car.class;
    }

    @Override
    public String getModelClassName() {
        return Car.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("carId", getCarId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());
        attributes.put("statusByUserId", getStatusByUserId());
        attributes.put("statusByUserName", getStatusByUserName());
        attributes.put("statusDate", getStatusDate());
        attributes.put("brand", getBrand());
        attributes.put("model", getModel());
        attributes.put("manufacturingYear", getManufacturingYear());
        attributes.put("fuelType", getFuelType());
        attributes.put("passengers", getPassengers());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long carId = (Long) attributes.get("carId");

        if (carId != null) {
            setCarId(carId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long statusByUserId = (Long) attributes.get("statusByUserId");

        if (statusByUserId != null) {
            setStatusByUserId(statusByUserId);
        }

        String statusByUserName = (String) attributes.get("statusByUserName");

        if (statusByUserName != null) {
            setStatusByUserName(statusByUserName);
        }

        Date statusDate = (Date) attributes.get("statusDate");

        if (statusDate != null) {
            setStatusDate(statusDate);
        }

        String brand = (String) attributes.get("brand");

        if (brand != null) {
            setBrand(brand);
        }

        String model = (String) attributes.get("model");

        if (model != null) {
            setModel(model);
        }

        Date manufacturingYear = (Date) attributes.get("manufacturingYear");

        if (manufacturingYear != null) {
            setManufacturingYear(manufacturingYear);
        }

        String fuelType = (String) attributes.get("fuelType");

        if (fuelType != null) {
            setFuelType(fuelType);
        }

        Integer passengers = (Integer) attributes.get("passengers");

        if (passengers != null) {
            setPassengers(passengers);
        }
    }

    /**
    * Returns the primary key of this car.
    *
    * @return the primary key of this car
    */
    @Override
    public long getPrimaryKey() {
        return _car.getPrimaryKey();
    }

    /**
    * Sets the primary key of this car.
    *
    * @param primaryKey the primary key of this car
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _car.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this car.
    *
    * @return the uuid of this car
    */
    @Override
    public java.lang.String getUuid() {
        return _car.getUuid();
    }

    /**
    * Sets the uuid of this car.
    *
    * @param uuid the uuid of this car
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _car.setUuid(uuid);
    }

    /**
    * Returns the car ID of this car.
    *
    * @return the car ID of this car
    */
    @Override
    public long getCarId() {
        return _car.getCarId();
    }

    /**
    * Sets the car ID of this car.
    *
    * @param carId the car ID of this car
    */
    @Override
    public void setCarId(long carId) {
        _car.setCarId(carId);
    }

    /**
    * Returns the group ID of this car.
    *
    * @return the group ID of this car
    */
    @Override
    public long getGroupId() {
        return _car.getGroupId();
    }

    /**
    * Sets the group ID of this car.
    *
    * @param groupId the group ID of this car
    */
    @Override
    public void setGroupId(long groupId) {
        _car.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this car.
    *
    * @return the company ID of this car
    */
    @Override
    public long getCompanyId() {
        return _car.getCompanyId();
    }

    /**
    * Sets the company ID of this car.
    *
    * @param companyId the company ID of this car
    */
    @Override
    public void setCompanyId(long companyId) {
        _car.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this car.
    *
    * @return the user ID of this car
    */
    @Override
    public long getUserId() {
        return _car.getUserId();
    }

    /**
    * Sets the user ID of this car.
    *
    * @param userId the user ID of this car
    */
    @Override
    public void setUserId(long userId) {
        _car.setUserId(userId);
    }

    /**
    * Returns the user uuid of this car.
    *
    * @return the user uuid of this car
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _car.getUserUuid();
    }

    /**
    * Sets the user uuid of this car.
    *
    * @param userUuid the user uuid of this car
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _car.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this car.
    *
    * @return the user name of this car
    */
    @Override
    public java.lang.String getUserName() {
        return _car.getUserName();
    }

    /**
    * Sets the user name of this car.
    *
    * @param userName the user name of this car
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _car.setUserName(userName);
    }

    /**
    * Returns the create date of this car.
    *
    * @return the create date of this car
    */
    @Override
    public java.util.Date getCreateDate() {
        return _car.getCreateDate();
    }

    /**
    * Sets the create date of this car.
    *
    * @param createDate the create date of this car
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _car.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this car.
    *
    * @return the modified date of this car
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _car.getModifiedDate();
    }

    /**
    * Sets the modified date of this car.
    *
    * @param modifiedDate the modified date of this car
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _car.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this car.
    *
    * @return the status of this car
    */
    @Override
    public int getStatus() {
        return _car.getStatus();
    }

    /**
    * Sets the status of this car.
    *
    * @param status the status of this car
    */
    @Override
    public void setStatus(int status) {
        _car.setStatus(status);
    }

    /**
    * Returns the status by user ID of this car.
    *
    * @return the status by user ID of this car
    */
    @Override
    public long getStatusByUserId() {
        return _car.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this car.
    *
    * @param statusByUserId the status by user ID of this car
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _car.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this car.
    *
    * @return the status by user uuid of this car
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _car.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this car.
    *
    * @param statusByUserUuid the status by user uuid of this car
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _car.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this car.
    *
    * @return the status by user name of this car
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _car.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this car.
    *
    * @param statusByUserName the status by user name of this car
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _car.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this car.
    *
    * @return the status date of this car
    */
    @Override
    public java.util.Date getStatusDate() {
        return _car.getStatusDate();
    }

    /**
    * Sets the status date of this car.
    *
    * @param statusDate the status date of this car
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _car.setStatusDate(statusDate);
    }

    /**
    * Returns the brand of this car.
    *
    * @return the brand of this car
    */
    @Override
    public java.lang.String getBrand() {
        return _car.getBrand();
    }

    /**
    * Sets the brand of this car.
    *
    * @param brand the brand of this car
    */
    @Override
    public void setBrand(java.lang.String brand) {
        _car.setBrand(brand);
    }

    /**
    * Returns the model of this car.
    *
    * @return the model of this car
    */
    @Override
    public java.lang.String getModel() {
        return _car.getModel();
    }

    /**
    * Sets the model of this car.
    *
    * @param model the model of this car
    */
    @Override
    public void setModel(java.lang.String model) {
        _car.setModel(model);
    }

    /**
    * Returns the manufacturing year of this car.
    *
    * @return the manufacturing year of this car
    */
    @Override
    public java.util.Date getManufacturingYear() {
        return _car.getManufacturingYear();
    }

    /**
    * Sets the manufacturing year of this car.
    *
    * @param manufacturingYear the manufacturing year of this car
    */
    @Override
    public void setManufacturingYear(java.util.Date manufacturingYear) {
        _car.setManufacturingYear(manufacturingYear);
    }

    /**
    * Returns the fuel type of this car.
    *
    * @return the fuel type of this car
    */
    @Override
    public java.lang.String getFuelType() {
        return _car.getFuelType();
    }

    /**
    * Sets the fuel type of this car.
    *
    * @param fuelType the fuel type of this car
    */
    @Override
    public void setFuelType(java.lang.String fuelType) {
        _car.setFuelType(fuelType);
    }

    /**
    * Returns the passengers of this car.
    *
    * @return the passengers of this car
    */
    @Override
    public int getPassengers() {
        return _car.getPassengers();
    }

    /**
    * Sets the passengers of this car.
    *
    * @param passengers the passengers of this car
    */
    @Override
    public void setPassengers(int passengers) {
        _car.setPassengers(passengers);
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _car.getApproved();
    }

    /**
    * Returns <code>true</code> if this car is approved.
    *
    * @return <code>true</code> if this car is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _car.isApproved();
    }

    /**
    * Returns <code>true</code> if this car is denied.
    *
    * @return <code>true</code> if this car is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _car.isDenied();
    }

    /**
    * Returns <code>true</code> if this car is a draft.
    *
    * @return <code>true</code> if this car is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _car.isDraft();
    }

    /**
    * Returns <code>true</code> if this car is expired.
    *
    * @return <code>true</code> if this car is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _car.isExpired();
    }

    /**
    * Returns <code>true</code> if this car is inactive.
    *
    * @return <code>true</code> if this car is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _car.isInactive();
    }

    /**
    * Returns <code>true</code> if this car is incomplete.
    *
    * @return <code>true</code> if this car is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _car.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this car is pending.
    *
    * @return <code>true</code> if this car is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _car.isPending();
    }

    /**
    * Returns <code>true</code> if this car is scheduled.
    *
    * @return <code>true</code> if this car is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _car.isScheduled();
    }

    @Override
    public boolean isNew() {
        return _car.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _car.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _car.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _car.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _car.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _car.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _car.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _car.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _car.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _car.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _car.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CarWrapper((Car) _car.clone());
    }

    @Override
    public int compareTo(com.rental.car.model.Car car) {
        return _car.compareTo(car);
    }

    @Override
    public int hashCode() {
        return _car.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.rental.car.model.Car> toCacheModel() {
        return _car.toCacheModel();
    }

    @Override
    public com.rental.car.model.Car toEscapedModel() {
        return new CarWrapper(_car.toEscapedModel());
    }

    @Override
    public com.rental.car.model.Car toUnescapedModel() {
        return new CarWrapper(_car.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _car.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _car.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _car.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CarWrapper)) {
            return false;
        }

        CarWrapper carWrapper = (CarWrapper) obj;

        if (Validator.equals(_car, carWrapper._car)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _car.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Car getWrappedCar() {
        return _car;
    }

    @Override
    public Car getWrappedModel() {
        return _car;
    }

    @Override
    public void resetOriginalValues() {
        _car.resetOriginalValues();
    }
}

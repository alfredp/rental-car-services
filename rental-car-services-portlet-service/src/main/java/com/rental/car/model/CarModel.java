package com.rental.car.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Car service. Represents a row in the &quot;RC_Car&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rental.car.model.impl.CarModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rental.car.model.impl.CarImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Car
 * @see com.rental.car.model.impl.CarImpl
 * @see com.rental.car.model.impl.CarModelImpl
 * @generated
 */
public interface CarModel extends BaseModel<Car>, GroupedModel, WorkflowedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a car model instance should use the {@link Car} interface instead.
     */

    /**
     * Returns the primary key of this car.
     *
     * @return the primary key of this car
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this car.
     *
     * @param primaryKey the primary key of this car
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this car.
     *
     * @return the uuid of this car
     */
    @AutoEscape
    public String getUuid();

    /**
     * Sets the uuid of this car.
     *
     * @param uuid the uuid of this car
     */
    public void setUuid(String uuid);

    /**
     * Returns the car ID of this car.
     *
     * @return the car ID of this car
     */
    public long getCarId();

    /**
     * Sets the car ID of this car.
     *
     * @param carId the car ID of this car
     */
    public void setCarId(long carId);

    /**
     * Returns the group ID of this car.
     *
     * @return the group ID of this car
     */
    public long getGroupId();

    /**
     * Sets the group ID of this car.
     *
     * @param groupId the group ID of this car
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this car.
     *
     * @return the company ID of this car
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this car.
     *
     * @param companyId the company ID of this car
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this car.
     *
     * @return the user ID of this car
     */
    public long getUserId();

    /**
     * Sets the user ID of this car.
     *
     * @param userId the user ID of this car
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this car.
     *
     * @return the user uuid of this car
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this car.
     *
     * @param userUuid the user uuid of this car
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this car.
     *
     * @return the user name of this car
     */
    @AutoEscape
    public String getUserName();

    /**
     * Sets the user name of this car.
     *
     * @param userName the user name of this car
     */
    public void setUserName(String userName);

    /**
     * Returns the create date of this car.
     *
     * @return the create date of this car
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this car.
     *
     * @param createDate the create date of this car
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this car.
     *
     * @return the modified date of this car
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this car.
     *
     * @param modifiedDate the modified date of this car
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the status of this car.
     *
     * @return the status of this car
     */
    public int getStatus();

    /**
     * Sets the status of this car.
     *
     * @param status the status of this car
     */
    public void setStatus(int status);

    /**
     * Returns the status by user ID of this car.
     *
     * @return the status by user ID of this car
     */
    public long getStatusByUserId();

    /**
     * Sets the status by user ID of this car.
     *
     * @param statusByUserId the status by user ID of this car
     */
    public void setStatusByUserId(long statusByUserId);

    /**
     * Returns the status by user uuid of this car.
     *
     * @return the status by user uuid of this car
     * @throws SystemException if a system exception occurred
     */
    public String getStatusByUserUuid() throws SystemException;

    /**
     * Sets the status by user uuid of this car.
     *
     * @param statusByUserUuid the status by user uuid of this car
     */
    public void setStatusByUserUuid(String statusByUserUuid);

    /**
     * Returns the status by user name of this car.
     *
     * @return the status by user name of this car
     */
    @AutoEscape
    public String getStatusByUserName();

    /**
     * Sets the status by user name of this car.
     *
     * @param statusByUserName the status by user name of this car
     */
    public void setStatusByUserName(String statusByUserName);

    /**
     * Returns the status date of this car.
     *
     * @return the status date of this car
     */
    public Date getStatusDate();

    /**
     * Sets the status date of this car.
     *
     * @param statusDate the status date of this car
     */
    public void setStatusDate(Date statusDate);

    /**
     * Returns the brand of this car.
     *
     * @return the brand of this car
     */
    @AutoEscape
    public String getBrand();

    /**
     * Sets the brand of this car.
     *
     * @param brand the brand of this car
     */
    public void setBrand(String brand);

    /**
     * Returns the model of this car.
     *
     * @return the model of this car
     */
    @AutoEscape
    public String getModel();

    /**
     * Sets the model of this car.
     *
     * @param model the model of this car
     */
    public void setModel(String model);

    /**
     * Returns the manufacturing year of this car.
     *
     * @return the manufacturing year of this car
     */
    public Date getManufacturingYear();

    /**
     * Sets the manufacturing year of this car.
     *
     * @param manufacturingYear the manufacturing year of this car
     */
    public void setManufacturingYear(Date manufacturingYear);

    /**
     * Returns the fuel type of this car.
     *
     * @return the fuel type of this car
     */
    @AutoEscape
    public String getFuelType();

    /**
     * Sets the fuel type of this car.
     *
     * @param fuelType the fuel type of this car
     */
    public void setFuelType(String fuelType);

    /**
     * Returns the passengers of this car.
     *
     * @return the passengers of this car
     */
    public int getPassengers();

    /**
     * Sets the passengers of this car.
     *
     * @param passengers the passengers of this car
     */
    public void setPassengers(int passengers);

    /**
     * @deprecated Renamed to {@link #isApproved()}
     */
    public boolean getApproved();

    /**
     * Returns <code>true</code> if this car is approved.
     *
     * @return <code>true</code> if this car is approved; <code>false</code> otherwise
     */
    public boolean isApproved();

    /**
     * Returns <code>true</code> if this car is denied.
     *
     * @return <code>true</code> if this car is denied; <code>false</code> otherwise
     */
    public boolean isDenied();

    /**
     * Returns <code>true</code> if this car is a draft.
     *
     * @return <code>true</code> if this car is a draft; <code>false</code> otherwise
     */
    public boolean isDraft();

    /**
     * Returns <code>true</code> if this car is expired.
     *
     * @return <code>true</code> if this car is expired; <code>false</code> otherwise
     */
    public boolean isExpired();

    /**
     * Returns <code>true</code> if this car is inactive.
     *
     * @return <code>true</code> if this car is inactive; <code>false</code> otherwise
     */
    public boolean isInactive();

    /**
     * Returns <code>true</code> if this car is incomplete.
     *
     * @return <code>true</code> if this car is incomplete; <code>false</code> otherwise
     */
    public boolean isIncomplete();

    /**
     * Returns <code>true</code> if this car is pending.
     *
     * @return <code>true</code> if this car is pending; <code>false</code> otherwise
     */
    public boolean isPending();

    /**
     * Returns <code>true</code> if this car is scheduled.
     *
     * @return <code>true</code> if this car is scheduled; <code>false</code> otherwise
     */
    public boolean isScheduled();

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Car car);

    public int hashCode();

    public CacheModel<Car> toCacheModel();

    public Car toEscapedModel();

    public String toString();

    public String toXmlString();
}

package com.rental.car.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rental.car.service.CarLocalServiceUtil;
import com.rental.car.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CarClp extends BaseModelImpl<Car> implements Car {
    private String _uuid;
    private long _carId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserUuid;
    private String _statusByUserName;
    private Date _statusDate;
    private String _brand;
    private String _model;
    private Date _manufacturingYear;
    private String _fuelType;
    private int _passengers;
    private BaseModel<?> _carRemoteModel;

    public CarClp() {
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
    public long getPrimaryKey() {
        return _carId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCarId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _carId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_carRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCarId() {
        return _carId;
    }

    @Override
    public void setCarId(long carId) {
        _carId = carId;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setCarId", long.class);

                method.invoke(_carRemoteModel, carId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_carRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_carRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_carRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_carRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_carRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_carRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_carRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatusByUserId() {
        return _statusByUserId;
    }

    @Override
    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserId", long.class);

                method.invoke(_carRemoteModel, statusByUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatusByUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
            _statusByUserUuid);
    }

    @Override
    public void setStatusByUserUuid(String statusByUserUuid) {
        _statusByUserUuid = statusByUserUuid;
    }

    @Override
    public String getStatusByUserName() {
        return _statusByUserName;
    }

    @Override
    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserName",
                        String.class);

                method.invoke(_carRemoteModel, statusByUserName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStatusDate() {
        return _statusDate;
    }

    @Override
    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusDate", Date.class);

                method.invoke(_carRemoteModel, statusDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBrand() {
        return _brand;
    }

    @Override
    public void setBrand(String brand) {
        _brand = brand;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setBrand", String.class);

                method.invoke(_carRemoteModel, brand);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getModel() {
        return _model;
    }

    @Override
    public void setModel(String model) {
        _model = model;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setModel", String.class);

                method.invoke(_carRemoteModel, model);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getManufacturingYear() {
        return _manufacturingYear;
    }

    @Override
    public void setManufacturingYear(Date manufacturingYear) {
        _manufacturingYear = manufacturingYear;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setManufacturingYear",
                        Date.class);

                method.invoke(_carRemoteModel, manufacturingYear);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFuelType() {
        return _fuelType;
    }

    @Override
    public void setFuelType(String fuelType) {
        _fuelType = fuelType;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setFuelType", String.class);

                method.invoke(_carRemoteModel, fuelType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPassengers() {
        return _passengers;
    }

    @Override
    public void setPassengers(int passengers) {
        _passengers = passengers;

        if (_carRemoteModel != null) {
            try {
                Class<?> clazz = _carRemoteModel.getClass();

                Method method = clazz.getMethod("setPassengers", int.class);

                method.invoke(_carRemoteModel, passengers);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Car.class.getName()));
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved}
     */
    @Override
    public boolean getApproved() {
        return isApproved();
    }

    @Override
    public boolean isApproved() {
        if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDenied() {
        if (getStatus() == WorkflowConstants.STATUS_DENIED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDraft() {
        if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpired() {
        if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInactive() {
        if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isIncomplete() {
        if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPending() {
        if (getStatus() == WorkflowConstants.STATUS_PENDING) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isScheduled() {
        if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
            return true;
        } else {
            return false;
        }
    }

    public BaseModel<?> getCarRemoteModel() {
        return _carRemoteModel;
    }

    public void setCarRemoteModel(BaseModel<?> carRemoteModel) {
        _carRemoteModel = carRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _carRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_carRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CarLocalServiceUtil.addCar(this);
        } else {
            CarLocalServiceUtil.updateCar(this);
        }
    }

    @Override
    public Car toEscapedModel() {
        return (Car) ProxyUtil.newProxyInstance(Car.class.getClassLoader(),
            new Class[] { Car.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CarClp clone = new CarClp();

        clone.setUuid(getUuid());
        clone.setCarId(getCarId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatus(getStatus());
        clone.setStatusByUserId(getStatusByUserId());
        clone.setStatusByUserName(getStatusByUserName());
        clone.setStatusDate(getStatusDate());
        clone.setBrand(getBrand());
        clone.setModel(getModel());
        clone.setManufacturingYear(getManufacturingYear());
        clone.setFuelType(getFuelType());
        clone.setPassengers(getPassengers());

        return clone;
    }

    @Override
    public int compareTo(Car car) {
        int value = 0;

        value = getBrand().compareTo(car.getBrand());

        if (value != 0) {
            return value;
        }

        value = getModel().compareTo(car.getModel());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CarClp)) {
            return false;
        }

        CarClp car = (CarClp) obj;

        long primaryKey = car.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", carId=");
        sb.append(getCarId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", statusByUserId=");
        sb.append(getStatusByUserId());
        sb.append(", statusByUserName=");
        sb.append(getStatusByUserName());
        sb.append(", statusDate=");
        sb.append(getStatusDate());
        sb.append(", brand=");
        sb.append(getBrand());
        sb.append(", model=");
        sb.append(getModel());
        sb.append(", manufacturingYear=");
        sb.append(getManufacturingYear());
        sb.append(", fuelType=");
        sb.append(getFuelType());
        sb.append(", passengers=");
        sb.append(getPassengers());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("com.rental.car.model.Car");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>carId</column-name><column-value><![CDATA[");
        sb.append(getCarId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusDate</column-name><column-value><![CDATA[");
        sb.append(getStatusDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>brand</column-name><column-value><![CDATA[");
        sb.append(getBrand());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>model</column-name><column-value><![CDATA[");
        sb.append(getModel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>manufacturingYear</column-name><column-value><![CDATA[");
        sb.append(getManufacturingYear());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fuelType</column-name><column-value><![CDATA[");
        sb.append(getFuelType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>passengers</column-name><column-value><![CDATA[");
        sb.append(getPassengers());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

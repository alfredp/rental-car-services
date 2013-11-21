package com.rental.car.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rental.car.service.http.CarServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.rental.car.service.http.CarServiceSoap
 * @generated
 */
public class CarSoap implements Serializable {
    private String _uuid;
    private long _carId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserName;
    private Date _statusDate;
    private String _brand;
    private String _model;
    private Date _manufacturingYear;
    private String _fuelType;
    private int _passengers;

    public CarSoap() {
    }

    public static CarSoap toSoapModel(Car model) {
        CarSoap soapModel = new CarSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setCarId(model.getCarId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatus(model.getStatus());
        soapModel.setStatusByUserId(model.getStatusByUserId());
        soapModel.setStatusByUserName(model.getStatusByUserName());
        soapModel.setStatusDate(model.getStatusDate());
        soapModel.setBrand(model.getBrand());
        soapModel.setModel(model.getModel());
        soapModel.setManufacturingYear(model.getManufacturingYear());
        soapModel.setFuelType(model.getFuelType());
        soapModel.setPassengers(model.getPassengers());

        return soapModel;
    }

    public static CarSoap[] toSoapModels(Car[] models) {
        CarSoap[] soapModels = new CarSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CarSoap[][] toSoapModels(Car[][] models) {
        CarSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CarSoap[models.length][models[0].length];
        } else {
            soapModels = new CarSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CarSoap[] toSoapModels(List<Car> models) {
        List<CarSoap> soapModels = new ArrayList<CarSoap>(models.size());

        for (Car model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CarSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _carId;
    }

    public void setPrimaryKey(long pk) {
        setCarId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getCarId() {
        return _carId;
    }

    public void setCarId(long carId) {
        _carId = carId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getStatusByUserId() {
        return _statusByUserId;
    }

    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;
    }

    public String getStatusByUserName() {
        return _statusByUserName;
    }

    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;
    }

    public Date getStatusDate() {
        return _statusDate;
    }

    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;
    }

    public String getBrand() {
        return _brand;
    }

    public void setBrand(String brand) {
        _brand = brand;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        _model = model;
    }

    public Date getManufacturingYear() {
        return _manufacturingYear;
    }

    public void setManufacturingYear(Date manufacturingYear) {
        _manufacturingYear = manufacturingYear;
    }

    public String getFuelType() {
        return _fuelType;
    }

    public void setFuelType(String fuelType) {
        _fuelType = fuelType;
    }

    public int getPassengers() {
        return _passengers;
    }

    public void setPassengers(int passengers) {
        _passengers = passengers;
    }
}

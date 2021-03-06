package com.rental.car.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rental.car.model.Car;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Car in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Car
 * @generated
 */
public class CarCacheModel implements CacheModel<Car>, Externalizable {
    public String uuid;
    public long carId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;
    public String brand;
    public String model;
    public long manufacturingYear;
    public String fuelType;
    public int passengers;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", carId=");
        sb.append(carId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append(", brand=");
        sb.append(brand);
        sb.append(", model=");
        sb.append(model);
        sb.append(", manufacturingYear=");
        sb.append(manufacturingYear);
        sb.append(", fuelType=");
        sb.append(fuelType);
        sb.append(", passengers=");
        sb.append(passengers);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Car toEntityModel() {
        CarImpl carImpl = new CarImpl();

        if (uuid == null) {
            carImpl.setUuid(StringPool.BLANK);
        } else {
            carImpl.setUuid(uuid);
        }

        carImpl.setCarId(carId);
        carImpl.setGroupId(groupId);
        carImpl.setCompanyId(companyId);
        carImpl.setUserId(userId);

        if (userName == null) {
            carImpl.setUserName(StringPool.BLANK);
        } else {
            carImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            carImpl.setCreateDate(null);
        } else {
            carImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            carImpl.setModifiedDate(null);
        } else {
            carImpl.setModifiedDate(new Date(modifiedDate));
        }

        carImpl.setStatus(status);
        carImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            carImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            carImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            carImpl.setStatusDate(null);
        } else {
            carImpl.setStatusDate(new Date(statusDate));
        }

        if (brand == null) {
            carImpl.setBrand(StringPool.BLANK);
        } else {
            carImpl.setBrand(brand);
        }

        if (model == null) {
            carImpl.setModel(StringPool.BLANK);
        } else {
            carImpl.setModel(model);
        }

        if (manufacturingYear == Long.MIN_VALUE) {
            carImpl.setManufacturingYear(null);
        } else {
            carImpl.setManufacturingYear(new Date(manufacturingYear));
        }

        if (fuelType == null) {
            carImpl.setFuelType(StringPool.BLANK);
        } else {
            carImpl.setFuelType(fuelType);
        }

        carImpl.setPassengers(passengers);

        carImpl.resetOriginalValues();

        return carImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        carId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        status = objectInput.readInt();
        statusByUserId = objectInput.readLong();
        statusByUserName = objectInput.readUTF();
        statusDate = objectInput.readLong();
        brand = objectInput.readUTF();
        model = objectInput.readUTF();
        manufacturingYear = objectInput.readLong();
        fuelType = objectInput.readUTF();
        passengers = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(carId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeInt(status);
        objectOutput.writeLong(statusByUserId);

        if (statusByUserName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusByUserName);
        }

        objectOutput.writeLong(statusDate);

        if (brand == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(brand);
        }

        if (model == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(model);
        }

        objectOutput.writeLong(manufacturingYear);

        if (fuelType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fuelType);
        }

        objectOutput.writeInt(passengers);
    }
}

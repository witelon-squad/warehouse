package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Hdd extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String capacity;

    @NotEmpty(message = "Cannot be empty")
    private String diskInterface;

    @NotEmpty(message = "Cannot be empty")
    private String format;

    @NotEmpty(message = "Cannot be empty")
    private String rotationSpeed;

    public Hdd() {
    }

    public Hdd(String capacity, String diskInterface, String format, String rotationSpeed) {
        this.capacity = capacity;
        this.diskInterface = diskInterface;
        this.format = format;
        this.rotationSpeed = rotationSpeed;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDiskInterface() {
        return diskInterface;
    }

    public void setDiskInterface(String diskInterface) {
        this.diskInterface = diskInterface;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(String rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hdd hdd = (Hdd) o;
        return Objects.equals(capacity, hdd.capacity) &&
                Objects.equals(diskInterface, hdd.diskInterface) &&
                Objects.equals(format, hdd.format) &&
                Objects.equals(rotationSpeed, hdd.rotationSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, diskInterface, format, rotationSpeed);
    }

    @Override
    public String toString() {
        return "Hdd{" +
                "capacity=" + capacity +
                ", diskInterface='" + diskInterface + '\'' +
                ", format=" + format +
                ", rotationSpeed=" + rotationSpeed +
                '}';
    }
}

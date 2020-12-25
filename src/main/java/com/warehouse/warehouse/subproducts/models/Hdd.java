package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Hdd extends Product {

    @NotNull(message = "Cannot be empty")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer capacity;

    @NotEmpty(message = "Cannot be empty")
    private String diskInterface;

    @NotNull(message = "Cannot be empty")
    @Min(value = 1, message = "Must be greater than 0")
    private Double format;

    @NotNull(message = "Cannot be empty")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer rotationSpeed;

    public Hdd() {
    }

    public Hdd(Integer capacity, String diskInterface, Double format, Integer rotationSpeed) {
        this.capacity = capacity;
        this.diskInterface = diskInterface;
        this.format = format;
        this.rotationSpeed = rotationSpeed;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDiskInterface() {
        return diskInterface;
    }

    public void setDiskInterface(String diskInterface) {
        this.diskInterface = diskInterface;
    }

    public Double getFormat() {
        return format;
    }

    public void setFormat(Double format) {
        this.format = format;
    }

    public Integer getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(Integer rotationSpeed) {
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

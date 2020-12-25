package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Ssd extends Product {

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer capacity;

    @NotEmpty(message = "Cannot be empty")
    private String diskInterface;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer writeSpeed;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer saveSpeed;

    public Ssd() {
    }

    public Ssd(Integer capacity, String diskInterface, Integer writeSpeed, Integer saveSpeed) {
        this.capacity = capacity;
        this.diskInterface = diskInterface;
        this.writeSpeed = writeSpeed;
        this.saveSpeed = saveSpeed;
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

    public Integer getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(Integer writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public Integer getSaveSpeed() {
        return saveSpeed;
    }

    public void setSaveSpeed(Integer saveSpeed) {
        this.saveSpeed = saveSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ssd ssd = (Ssd) o;
        return Objects.equals(capacity, ssd.capacity) &&
                Objects.equals(diskInterface, ssd.diskInterface) &&
                Objects.equals(writeSpeed, ssd.writeSpeed) &&
                Objects.equals(saveSpeed, ssd.saveSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, diskInterface, writeSpeed, saveSpeed);
    }

    @Override
    public String toString() {
        return "Ssd{" +
                "capacity=" + capacity +
                ", diskInterface='" + diskInterface + '\'' +
                ", writeSpeed=" + writeSpeed +
                ", saveSpeed=" + saveSpeed +
                '}';
    }
}

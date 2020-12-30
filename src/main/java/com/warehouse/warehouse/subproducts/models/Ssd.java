package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Ssd extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String capacity;

    @NotEmpty(message = "Cannot be empty")
    private String diskInterface;

    @NotEmpty(message = "Cannot be empty")
    private String writeSpeed;

    @NotEmpty(message = "Cannot be empty")
    private String saveSpeed;

    public Ssd() {
    }

    public Ssd(String capacity, String diskInterface, String writeSpeed, String saveSpeed) {
        this.capacity = capacity;
        this.diskInterface = diskInterface;
        this.writeSpeed = writeSpeed;
        this.saveSpeed = saveSpeed;
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

    public String getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(String writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public String getSaveSpeed() {
        return saveSpeed;
    }

    public void setSaveSpeed(String saveSpeed) {
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

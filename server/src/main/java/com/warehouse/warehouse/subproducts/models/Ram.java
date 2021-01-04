package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Ram extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String totalCapacity;

    @NotEmpty(message = "Cannot be empty")
    private String typeOfMemory;

    @NotEmpty(message = "Cannot be empty")
    private String speed;

    @NotEmpty(message = "Cannot be empty")
    private String delay;

    public Ram() {
    }

    public Ram(String totalCapacity, String typeOfMemory, String speed, String delay) {
        this.totalCapacity = totalCapacity;
        this.typeOfMemory = typeOfMemory;
        this.speed = speed;
        this.delay = delay;
    }

    public String getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(String totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getTypeOfMemory() {
        return typeOfMemory;
    }

    public void setTypeOfMemory(String typeOfMemory) {
        this.typeOfMemory = typeOfMemory;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ram ram = (Ram) o;
        return Objects.equals(totalCapacity, ram.totalCapacity) &&
                Objects.equals(typeOfMemory, ram.typeOfMemory) &&
                Objects.equals(speed, ram.speed) &&
                Objects.equals(delay, ram.delay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalCapacity, typeOfMemory, speed, delay);
    }

    @Override
    public String toString() {
        return "Ram{" +
                "totalCapacity=" + totalCapacity +
                ", typeOfMemory='" + typeOfMemory + '\'' +
                ", speed=" + speed +
                ", delay=" + delay +
                '}';
    }
}

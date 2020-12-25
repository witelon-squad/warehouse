package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Ram extends Product {

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer totalCapacity;

    @NotEmpty(message = "Cannot be empty")
    private String typeOfMemory;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer speed;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer delay;

    public Ram() {
    }

    public Ram(Integer totalCapacity, String typeOfMemory, Integer speed, Integer delay) {
        this.totalCapacity = totalCapacity;
        this.typeOfMemory = typeOfMemory;
        this.speed = speed;
        this.delay = delay;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getTypeOfMemory() {
        return typeOfMemory;
    }

    public void setTypeOfMemory(String typeOfMemory) {
        this.typeOfMemory = typeOfMemory;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
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

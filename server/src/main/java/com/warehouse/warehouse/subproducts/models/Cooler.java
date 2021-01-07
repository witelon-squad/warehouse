package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Cooler extends Product {


    @NotEmpty(message = "Cannot be empty")
    private String typeOfColling;

    @NotEmpty(message = "Cannot be empty")
    private String fan;

    @NotEmpty(message = "Cannot be empty")
    private String speedControl;

    public Cooler() {
    }

    public Cooler(String typeOfColling, String fan, String speedControl) {
        this.typeOfColling = typeOfColling;
        this.fan = fan;
        this.speedControl = speedControl;
    }

    public String getTypeOfColling() {
        return typeOfColling;
    }

    public void setTypeOfColling(String typeOfColling) {
        this.typeOfColling = typeOfColling;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public String getSpeedControl() {
        return speedControl;
    }

    public void setSpeedControl(String speedControl) {
        this.speedControl = speedControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cooler cooler = (Cooler) o;
        return Objects.equals(typeOfColling, cooler.typeOfColling) &&
                Objects.equals(fan, cooler.fan) &&
                Objects.equals(speedControl, cooler.speedControl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfColling, fan, speedControl);
    }

    @Override
    public String toString() {
        return "Cooler{" +
                "typeOfColling='" + typeOfColling + '\'' +
                ", fan='" + fan + '\'' +
                ", speedControl='" + speedControl + '\'' +
                '}';
    }
}

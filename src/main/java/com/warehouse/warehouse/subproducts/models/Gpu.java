package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Gpu extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String layout;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private int vram;

    @NotEmpty(message = "Cannot be empty")
    private String typeOfMemory;

    public Gpu() {
    }

    public Gpu(String layout, int vram, String typeOfMemory) {
        this.layout = layout;
        this.vram = vram;
        this.typeOfMemory = typeOfMemory;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getVram() {
        return vram;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public String getTypeOfMemory() {
        return typeOfMemory;
    }

    public void setTypeOfMemory(String typeOfMemory) {
        this.typeOfMemory = typeOfMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gpu gpu = (Gpu) o;
        return vram == gpu.vram &&
                Objects.equals(layout, gpu.layout) &&
                Objects.equals(typeOfMemory, gpu.typeOfMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layout, vram, typeOfMemory);
    }

    @Override
    public String toString() {
        return "Gpu{" +
                "layout='" + layout + '\'' +
                ", vram=" + vram +
                ", typeOfMemory='" + typeOfMemory + '\'' +
                '}';
    }
}

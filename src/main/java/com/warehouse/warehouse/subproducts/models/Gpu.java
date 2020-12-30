package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Gpu extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String layout;

    @NotEmpty(message = "Cannot be empty")
    private String vram;

    @NotEmpty(message = "Cannot be empty")
    private String typeOfMemory;

    public Gpu() {
    }

    public Gpu(String layout, String vram, String typeOfMemory) {
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

    public String getVram() {
        return vram;
    }

    public void setVram(String vram) {
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

package com.warehouse.warehouse.subproducts.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Gpu extends Product {

    private String layout;

    private int vram;

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

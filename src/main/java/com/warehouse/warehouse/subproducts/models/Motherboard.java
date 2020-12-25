package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Motherboard extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String format;

    @NotEmpty(message = "Cannot be empty")
    private String cpuSocket;

    @NotEmpty(message = "Cannot be empty")
    private String chipset;

    public Motherboard() {
    }

    public Motherboard(String format, String cpuSocket, String chipset) {
        this.format = format;
        this.cpuSocket = cpuSocket;
        this.chipset = chipset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motherboard that = (Motherboard) o;
        return Objects.equals(format, that.format) &&
                Objects.equals(cpuSocket, that.cpuSocket) &&
                Objects.equals(chipset, that.chipset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), format, cpuSocket, chipset);
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "format='" + format + '\'' +
                ", cpuSocket='" + cpuSocket + '\'' +
                ", chipset='" + chipset + '\'' +
                '}';
    }
}

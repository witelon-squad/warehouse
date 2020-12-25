package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Psu extends Product {

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer power;

    @NotEmpty(message = "Cannot be empty")
    private String standard;

    @NotEmpty(message = "Cannot be empty")
    private String efficiency;

    @NotEmpty(message = "Cannot be empty")
    private String certificate;

    public Psu() {
    }

    public Psu(Integer power, String standard, String efficiency, String certificate) {
        this.power = power;
        this.standard = standard;
        this.efficiency = efficiency;
        this.certificate = certificate;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Psu psu = (Psu) o;
        return Objects.equals(power, psu.power) &&
                Objects.equals(standard, psu.standard) &&
                Objects.equals(efficiency, psu.efficiency) &&
                Objects.equals(certificate, psu.certificate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), power, standard, efficiency, certificate);
    }

    @Override
    public String toString() {
        return "Psu{" +
                "power=" + power +
                ", standard='" + standard + '\'' +
                ", efficiency='" + efficiency + '\'' +
                ", certificate='" + certificate + '\'' +
                '}';
    }
}

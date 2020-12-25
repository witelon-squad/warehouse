package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Cpu extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String series;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Double timing;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer cores;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer cache;

    public Cpu() {
    }

    public Cpu(String series, Double timing, Integer cores, Integer cache) {
        this.series = series;
        this.timing = timing;
        this.cores = cores;
        this.cache = cache;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Double getTiming() {
        return timing;
    }

    public void setTiming(Double timing) {
        this.timing = timing;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cpu cpu = (Cpu) o;
        return Objects.equals(series, cpu.series) &&
                Objects.equals(timing, cpu.timing) &&
                Objects.equals(cores, cpu.cores) &&
                Objects.equals(cache, cpu.cache);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), series, timing, cores, cache);
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "series='" + series + '\'' +
                ", timing=" + timing +
                ", cores=" + cores +
                ", cache=" + cache +
                '}';
    }
}

package com.warehouse.warehouse.subproducts.models;

import com.warehouse.warehouse.product.Product;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Cpu extends Product {

    @NotEmpty(message = "Cannot be empty")
    private String series;

    @NotEmpty(message = "Cannot be empty")
    private String timing;

    @NotEmpty(message = "Cannot be empty")
    private String cores;

    @NotEmpty(message = "Cannot be empty")
    private String cache;

    public Cpu() {
    }

    public Cpu(@NotEmpty(message = "Cannot be empty") String series, @NotEmpty(message = "Cannot be empty") String timing, @NotEmpty(message = "Cannot be empty") String cores, @NotEmpty(message = "Cannot be empty") String cache) {
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

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
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

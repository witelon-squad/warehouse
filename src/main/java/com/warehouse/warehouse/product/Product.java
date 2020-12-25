package com.warehouse.warehouse.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.warehouse.warehouse.subproducts.models.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Gpu.class, name = "gpu"),
        @JsonSubTypes.Type(value = Cooler.class, name = "cooler"),
        @JsonSubTypes.Type(value = Cpu.class, name = "cpu"),
        @JsonSubTypes.Type(value = Hdd.class, name = "hdd"),
        @JsonSubTypes.Type(value = Motherboard.class, name = "motherboard"),
        @JsonSubTypes.Type(value = Psu.class, name = "psu"),
        @JsonSubTypes.Type(value = Ram.class, name = "ram"),
        @JsonSubTypes.Type(value = Ssd.class, name = "ssd"),
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Cannot be empty")
    private String name;

    @NotEmpty(message = "Cannot be empty")
    private String description;

    @NotNull(message = "Cannot be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Double price;

    private LocalDateTime createdAt;

    @NotEmpty(message = "Cannot be null")
    @JsonProperty
    private String type;

    public Product() {
    }

    public Product(String name, String description, Double price, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(createdAt, product.createdAt) &&
                Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, createdAt, type);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", type='" + type + '\'' +
                '}';
    }
}

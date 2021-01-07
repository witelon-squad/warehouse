package com.warehouse.warehouse.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Could not find products with id " + id);
    }
}

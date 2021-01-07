package com.warehouse.warehouse.product;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product) {

        EntityModel<Product> productModel = EntityModel.of(product,
                linkTo(methodOn(ProductController.class).getOneProduct(product.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getAllProducts()).withRel("products"));

        return productModel;
    }


}

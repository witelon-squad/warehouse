package com.warehouse.warehouse.product;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.warehouse.warehouse.exceptions.ProductNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductRepository repository;
    private final ProductModelAssembler assembler;

    public ProductController(ProductRepository repository, ProductModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/products")
    public CollectionModel<EntityModel<Product>> allProducts() {
        List<EntityModel<Product>> products = repository.findAll().stream().map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(products,
                linkTo(methodOn(ProductController.class).allProducts()).withSelfRel());
    }

    @GetMapping("/products/{id}")
    public EntityModel<Product> one(@PathVariable Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        return assembler.toModel(product);
    }

    @PostMapping("/products")
    public ResponseEntity<EntityModel<Product>> newProduct(@RequestBody Product product) {

        product.setCreatedAt(LocalDateTime.now());
        Product newProduct = repository.save(product);

        return ResponseEntity
                .created(linkTo(methodOn(ProductController.class).one(newProduct.getId())).toUri())
                .body(assembler.toModel(newProduct));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        repository.deleteById(id);
        return new ResponseEntity<String>("Movie Deleted", HttpStatus.OK);
    }



}

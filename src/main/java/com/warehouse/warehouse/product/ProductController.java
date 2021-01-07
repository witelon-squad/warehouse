package com.warehouse.warehouse.product;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.warehouse.warehouse.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://95.111.242.110:9090")
@RestController
public class ProductController {

    private final ProductRepository repository;
    private final ProductModelAssembler assembler;

    @Autowired
    public ProductController(ProductRepository repository, ProductModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/products")
    public CollectionModel<EntityModel<Product>> getAllProducts() {
        List<EntityModel<Product>> products = repository.findAll().stream().map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(products,
                linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
    }

    @GetMapping("/products/{id}")
    public EntityModel<Product> getOneProduct(@PathVariable Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        return assembler.toModel(product);
    }

    @PostMapping("/products")
    public ResponseEntity<EntityModel<Product>> newProduct(@Valid @RequestBody Product product) {

        product.setCreatedAt(LocalDateTime.now());
        Product newProduct = repository.save(product);

        return ResponseEntity
                .created(linkTo(methodOn(ProductController.class).getOneProduct(newProduct.getId())).toUri())
                .body(assembler.toModel(newProduct));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        repository.deleteById(id);
        return new ResponseEntity<String>("Product has been deleted", HttpStatus.OK);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<?> substractQuantity(@Valid @PathVariable Long id){

        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setQuantity(product.getQuantity() - 1);
        repository.save(product);

        return ResponseEntity
                .ok().body(assembler.toModel(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> editProduct(@Valid @PathVariable Long id, @RequestBody Product productChanges){

        Product updatedProduct = repository.findById(id)
                .map(product -> {
                    product.setName(productChanges.getName());
                    product.setDescription(productChanges.getDescription());
                    product.setPrice(productChanges.getPrice());
                    product.setQuantity(productChanges.getQuantity());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    productChanges.setId(id);
                    return repository.save(productChanges);
                });

        return ResponseEntity
                .ok().body(assembler.toModel(updatedProduct));
    }






}

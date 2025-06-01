package com.example.products.controller;

import com.example.products.model.pojo.Product;
import com.example.products.model.request.CreateProductRequest;
import com.example.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.products.repository.ProductRepository;
import java.util.Optional;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService service;
    private final ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductsService service, ProductRepository productRepository) {
        this.service = service;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = service.getProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        return products != null && !products.isEmpty()
                ? ResponseEntity.ok(products)
                : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request) {
        Product createdProduct = service.createProduct(request);
        return createdProduct != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(createdProduct)
                : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        Boolean removed = service.removeProduct(id);
        return Boolean.TRUE.equals(removed)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/stock/{productCode}")
    public ResponseEntity<Boolean> checkStock(@PathVariable String productCode) {
        Optional<Product> product = productRepository.findByProductCode(productCode);
        return ResponseEntity.ok(product.isPresent() && product.get().getStock() > 0);
    }
}

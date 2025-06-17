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
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController {

    private final ProductsService service;
    private final ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductsService service, ProductRepository productRepository) {
        this.service = service;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
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
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Boolean removed = service.removeProduct(id);
        return Boolean.TRUE.equals(removed)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Void> updateStock(@PathVariable Long id, @RequestParam int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = optionalProduct.get();

        if (product.getStock() < quantity) {
            return ResponseEntity.badRequest().build(); // stock insuficiente
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }



}

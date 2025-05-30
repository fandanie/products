package com.example.products.controller;

import com.example.products.model.pojo.Product;
import com.example.products.model.request.CreateProductRequest;
import com.example.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductsService service;

    @Autowired
    public ProductsController(ProductsService service) {
        this.service = service;
    }


    @GetMapping("/stock/{productCode}")
    public ResponseEntity<Boolean> checkStock(@PathVariable String productCode) {
        Optional<Product> product = productRepository.findByProductCode(productCode);
        if (product.isPresent() && product.get().getStock() > 0) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        if (products != null) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Product product = service.getProduct(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        Boolean removed = service.removeProduct(productId);
        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request) {
        Product createdProduct = service.createProduct(request);
        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

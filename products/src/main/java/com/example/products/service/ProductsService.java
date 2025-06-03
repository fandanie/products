package com.example.products.service;

import java.util.List;
import com.example.products.model.pojo.Product;
import com.example.products.model.request.CreateProductRequest;

public interface ProductsService {
    List<Product> getProducts();
    Product getProduct(Long productId);
    Boolean removeProduct(Long productId);
    Product createProduct(CreateProductRequest request);

}
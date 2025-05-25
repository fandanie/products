package com.example.products.service;

import java.util.List;
import com.example.products.model.pojo.Product;
import com.example.products.model.request.CreateProductRequest;

public interface ProductsService {
    List<Product> getProducts();
    Product getProduct(String productId);
    Boolean removeProduct(String productId);
    Product createProduct(CreateProductRequest request);

}
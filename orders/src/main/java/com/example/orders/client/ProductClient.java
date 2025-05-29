package com.example.orders.client;

import com.example.orders.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/products/{code}")
    Product getProductByCode(@PathVariable("code") String code);
}

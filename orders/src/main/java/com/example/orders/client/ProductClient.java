package com.example.orders.client;

import com.example.orders.dto.OrderResponse;
import com.example.orders.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable("id") Long id);

    @PutMapping("api/products/{id}/stock")
    void updateStock(@PathVariable Long id, @RequestParam int quantity);
}

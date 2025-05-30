package com.example.orders.service;

import com.example.orders.model.Order;
import com.example.orders.model.request.CreateOrderRequest;
import com.example.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.orders.dto.ProductResponse;



import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate RestTemplate;
    private OrderRepository repository;

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public Order createOrder(CreateOrderRequest request) {
        // Llamar al ProductService para obtener el producto
        String url = "http://products-service/api/products/" + request.getProductCode();
        ProductResponse product = RestTemplate.getForObject(url, ProductResponse.class);

        // Verificar stock
        if (product == null || product.getStock() < request.getQuantity()) {
            throw new RuntimeException("Stock insuficiente para el producto: " + request.getProductCode());
        }


        Order order = Order.builder()
                .customerName(request.getCustomerName())
                .productCode(request.getProductCode())
                .quantity(request.getQuantity())
                .status(request.getStatus())
                .orderDate(LocalDateTime.now())
                .build();
        return repository.save(order);
    }

    @Override
    public boolean deleteOrder(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

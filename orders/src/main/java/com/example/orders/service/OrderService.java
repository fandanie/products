package com.example.orders.service;

import com.example.orders.model.Order;
import com.example.orders.model.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    List<Order> getOrdersByStatus(String status);
    Order createOrder(CreateOrderRequest request);
    boolean deleteOrder(Long id);
}

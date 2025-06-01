package com.example.orders.service;

import com.example.orders.model.Order;
import com.example.orders.model.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder(CreateOrderRequest request);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByStatus(String status);
    boolean deleteOrder(Long id);
}

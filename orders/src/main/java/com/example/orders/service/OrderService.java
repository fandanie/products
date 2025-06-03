package com.example.orders.service;
import com.example.orders.dto.OrderResponse;
import com.example.orders.model.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(CreateOrderRequest request);
    OrderResponse getOrderById(Long id);
    List<OrderResponse> getAllOrders();
    boolean deleteOrder(Long id);
}

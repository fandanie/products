package com.example.orders.service;

import com.example.orders.client.ProductClient;
import com.example.orders.dto.ProductResponse;
import com.example.orders.model.Order;
import com.example.orders.model.request.CreateOrderRequest;
import com.example.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Override
    public Order createOrder(CreateOrderRequest request) {
        ProductResponse product = productClient.getProductById(request.getProductId());

        if (product.getStock() < request.getQuantity()) {
            throw new IllegalArgumentException("Stock insuficiente para el producto solicitado.");
        }

        BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .customerName(request.getCustomerName())
                .productId(product.getId())
                .quantity(request.getQuantity())
                .totalPrice(total)
                .createdAt(LocalDateTime.now())
                .status("PENDING")
                .build();

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada con ID: " + id));
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public boolean deleteOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

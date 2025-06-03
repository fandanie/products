package com.example.orders.service;

import com.example.orders.client.ProductClient;
import com.example.orders.dto.OrderResponse;
import com.example.orders.model.Order;
import com.example.orders.dto.Product;
import com.example.orders.model.request.CreateOrderRequest;
import com.example.orders.repository.OrderRepository;
import com.example.orders.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {
        Product product = productClient.getProductById(request.getId());

        if (product.getStock() == null || product.getStock() < request.getQuantity()) {
            throw new IllegalArgumentException("Stock insuficiente para el producto solicitado.");
        }

        BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));

        Order order = Order.builder()
                .productId(product.getId())
                .name(request.getCustomerName())
                .quantity(request.getQuantity())
                .price(product.getPrice())
                .totalPrice(total)
                .stock(product.getStock())
                .build();
        Order savedOrder = orderRepository.save(order);

        OrderResponse response = OrderMapper.toDto(savedOrder);
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setName(product.getName());

        return response;

    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order =orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Orden no encontrada con ID: " + id));
        return OrderMapper.toDto(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderMapper::toDto).toList();
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

package com.example.orders.mapper;

import com.example.orders.dto.OrderResponse;
import com.example.orders.model.Order;

public class OrderMapper {

    public static OrderResponse toDto(Order order) {
        OrderResponse dto = new OrderResponse();
        dto.setProductId(order.getProductId());
        dto.setName(order.getName());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());

        return dto;
    }
}

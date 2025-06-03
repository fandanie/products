package com.example.orders.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data

public class OrderResponse {
    private Long productId;
    private String name;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private int stock;
}


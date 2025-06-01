package com.example.orders.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data

public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
}


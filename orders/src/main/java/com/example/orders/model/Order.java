package com.example.orders.model;

import jakarta.persistence.*;
import jakarta.persistence.Version;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private Long productId;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private int stock;
    @Version
    private int version;

}

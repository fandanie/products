package com.example.orders.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

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

    private String customerName;
    private String productCode;
    private Integer quantity;
    @CreationTimestamp
    private LocalDateTime orderDate;
    private String status;

    @PrePersist
    public void generateProductCode() {
        if (this.productCode == null || this.productCode.isEmpty()) {
            this.productCode = "PRD-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        }
    }
}

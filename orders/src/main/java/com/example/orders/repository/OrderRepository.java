package com.example.orders.repository;

import com.example.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
   // List<Order> findByStatus(String status);
}

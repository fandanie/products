package com.example.products.repository;

import java.util.List;
import com.example.products.model.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
    Optional<Product> findByProductCode(String productCode);

}

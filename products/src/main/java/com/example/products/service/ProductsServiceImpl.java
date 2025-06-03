package com.example.products.service;


import org.springframework.stereotype.Service;
import com.example.products.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import com.example.products.model.pojo.Product;
import com.example.products.model.request.CreateProductRequest;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        List<Product> products = repository.findAll();
        return products.isEmpty() ? null : products;
    }

    @Override
    public Product getProduct(Long productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Boolean removeProduct(Long productId) {
        Product product = repository.findById(productId).orElse(null);
        if (product != null) {
            repository.delete(product);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Product createProduct(CreateProductRequest request) {
        if (request != null &&
                org.springframework.util.StringUtils.hasLength(request.getName())) {

            Product product = Product.builder()
                    .name(request.getName().trim())
                    .price(request.getPrice())
                    .stock(request.getStock())
                    .build();
            return repository.save(product);
        }
        return null;
    }
}
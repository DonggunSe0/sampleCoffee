package org.example.shop.service;

import org.example.shop.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "커피콩", "Columbia Nariñó", 5000, "https://i.imgur.com/HKOFQYa.jpeg"));
        products.add(new Product(2L, "커피콩", "Brazil Serra Do Caparaó", 6000, "https://i.imgur.com/HKOFQYa.jpeg"));
        products.add(new Product(3L, "커피콩", "Ethiopia Yirgacheffe", 7000, "https://i.imgur.com/HKOFQYa.jpeg"));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(Long productId) {
        return products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }
}

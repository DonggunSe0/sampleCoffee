package org.example.shop.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private String email;
    private String address;
    private String postcode;
    private int totalPrice;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;

    public Order(Long id, String email, String address, String postcode, int totalPrice, List<OrderItem> orderItems, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

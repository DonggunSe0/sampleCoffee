package org.example.shop.dto;

public class OrderResponse {
    private Long orderId;
    private String message;
    private int totalPrice;

    public OrderResponse(Long orderId, String message, int totalPrice) {
        this.orderId = orderId;
        this.message = message;
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getMessage() {
        return message;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
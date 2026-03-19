package org.example.shop.dto;

public class AddCartItemRequest {
    private Long productId;
    private int quantity;

    public AddCartItemRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

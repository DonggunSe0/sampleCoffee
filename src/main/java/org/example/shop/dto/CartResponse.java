package org.example.shop.dto;

import java.util.List;

public class CartResponse {
    private List<CartItemDto> items;
    private int totalPrice;

    public CartResponse(List<CartItemDto> items, int totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}

package org.example.shop.service;


import org.example.shop.model.Product;
import org.example.shop.dto.CartItemDto;
import org.example.shop.dto.CartResponse;
import org.example.shop.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final ProductService productService;
    private final List<CartItem> cartItems = new ArrayList<>();

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public CartResponse getCart() {
        List<CartItemDto> itemDtos = new ArrayList<>();
        int totalPrice = 0;

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            int itemTotalPrice = product.getPrice() * cartItem.getQuantity();
            totalPrice += itemTotalPrice;

            itemDtos.add(new CartItemDto(
                    product.getId(),
                    product.getCategory(),
                    product.getName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    cartItem.getQuantity(),
                    itemTotalPrice
            ));
        }

        return new CartResponse(itemDtos, totalPrice);
    }

    public void addItem(Long productId, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        }

        Product product = productService.findById(productId);

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(productId)) {
                cartItem.addQuantity(quantity);
                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));
    }

    public void removeItem(Long productId) {
        boolean removed = cartItems.removeIf(item -> item.getProduct().getId().equals(productId));

        if (!removed) {
            throw new IllegalArgumentException("장바구니에 해당 상품이 없습니다.");
        }
    }

    public List<CartItem> getCartItemsRaw() {
        return cartItems;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
package org.example.shop.controller;

import org.example.shop.dto.AddCartItemRequest;
import org.example.shop.dto.CartResponse;
import org.example.shop.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/api/cart")
    public CartResponse getCart() {
        return cartService.getCart();
    }

    @PostMapping("/api/cart/items")
    public String addCartItem(@RequestBody AddCartItemRequest request) {
        cartService.addItem(request.getProductId(), request.getQuantity());
        return "장바구니에 상품이 추가되었습니다.";
    }

    @DeleteMapping("/api/cart/items/{productId}")
    public String removeCartItem(@PathVariable Long productId) {
        cartService.removeItem(productId);
        return "장바구니에서 상품이 삭제되었습니다.";
    }
}
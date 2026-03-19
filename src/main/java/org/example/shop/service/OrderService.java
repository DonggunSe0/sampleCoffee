package org.example.shop.service;


import org.example.shop.dto.OrderRequest;
import org.example.shop.dto.OrderResponse;
import org.example.shop.model.CartItem;
import org.example.shop.model.Order;
import org.example.shop.model.OrderItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final org.example.shop.service.CartService cartService;
    private final List<Order> orders = new ArrayList<>();
    private Long orderSequence = 1L;

    public OrderService(org.example.shop.service.CartService cartService) {
        this.cartService = cartService;
    }

    public OrderResponse createOrder(OrderRequest request) {
        validateOrderRequest(request);

        if (cartService.isEmpty()) {
            throw new IllegalArgumentException("장바구니가 비어 있습니다.");
        }

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartService.getCartItemsRaw()) {
            orderItems.add(new OrderItem(
                    cartItem.getProduct().getName(),
                    cartItem.getProduct().getPrice(),
                    cartItem.getQuantity()
            ));
        }

        int totalPrice = cartService.calculateTotalPrice();

        Order order = new Order(
                orderSequence++,
                request.getEmail(),
                request.getAddress(),
                request.getPostcode(),
                totalPrice,
                orderItems,
                LocalDateTime.now()
        );

        orders.add(order);
        cartService.clearCart();

        return new OrderResponse(order.getId(), "주문이 완료되었습니다.", order.getTotalPrice());
    }

    public List<Order> findAllOrders() {
        return orders;
    }

    public Order findOrderById(Long orderId) {
        return orders.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));
    }

    private void validateOrderRequest(OrderRequest request) {
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new IllegalArgumentException("이메일은 필수입니다.");
        }
        if (request.getAddress() == null || request.getAddress().isBlank()) {
            throw new IllegalArgumentException("주소는 필수입니다.");
        }
        if (request.getPostcode() == null || request.getPostcode().isBlank()) {
            throw new IllegalArgumentException("우편번호는 필수입니다.");
        }
    }
}

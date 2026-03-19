package org.example.shop.dto;

public class CartItemDto {
    private Long productId;
    private String category;
    private String name;
    private int price;
    private String imageUrl;
    private int quantity;
    private int itemTotalPrice;

    public CartItemDto(Long productId, String category, String name, int price, String imageUrl, int quantity, int itemTotalPrice) {
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.itemTotalPrice = itemTotalPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getItemTotalPrice() {
        return itemTotalPrice;
    }
}

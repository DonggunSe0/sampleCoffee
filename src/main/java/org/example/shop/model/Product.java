package org.example.shop.model;

public class Product {
    private Long id;
    private String category;
    private String name;
    private int price;
    private String imageUrl;

    public Product(Long id, String category, String name, int price, String imageUrl) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
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
}

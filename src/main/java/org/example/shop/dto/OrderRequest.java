package org.example.shop.dto;

public class OrderRequest {
    private String email;
    private String address;
    private String postcode;

    public OrderRequest() {
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
}

package com.vanshika.ecom.model;

public class WishlistRequest {

    private String username;
    private String productId;

    public WishlistRequest(String username, String productId) {
        this.username = username;
        this.productId = productId;
    }

    public WishlistRequest() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductName(String productId) {
        this.productId = productId;
    }
}

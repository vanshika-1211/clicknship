package com.vanshika.ecom.model;

public class CartRequest {

    private String username;
    private String productId;
    private String productAmt;

    public CartRequest(String username, String productId, String productAmt) {
        this.username = username;
        this.productId = productId;
        this.productAmt = productAmt;
    }

    public CartRequest() {

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

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductAmt() {
        return productAmt;
    }

    public void setProductAmt(String productAmt) {
        this.productAmt = productAmt;
    }
}

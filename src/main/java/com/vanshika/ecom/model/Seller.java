package com.vanshika.ecom.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Product name is required")
    private String name;
    private Double price;
    private Integer stock;
    private String sellerBrand;
    private String category;
    private String subCategory;

    //@Column(name = "picByte", length=1000)
    //private byte[] picByte;
    private String fit;
    private String material;
    private String prodType;
    private String sellerUsername;

    public Seller(@NotNull(message = "Product name is required.") String name, Double price, Integer stock, String sellerBrand, String category, String subCategory, String fit, String material, String prodType, String sellerUsername) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sellerBrand = sellerBrand;
        this.category = category;
        this.subCategory = subCategory;
        //this.picByte = picByte;
        this.fit=fit;
        this.material=material;
        this.prodType=prodType;
        this.sellerUsername=sellerUsername;
    }


    public Seller() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String sellerBrand() {
        return sellerBrand;
    }

    public void setSellerBrand(String sellerBrand) {
        this.sellerBrand = sellerBrand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /*public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
*/
    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
}

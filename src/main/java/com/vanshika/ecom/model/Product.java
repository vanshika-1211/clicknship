package com.vanshika.ecom.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required")
    @Basic(optional = false)
    private String name;
    private Double price;
    private Integer stock;
    private String seller;
    private String category;
    private String subCategory;
    private String pictureUrl;
    private String fit;
    private String material;
    private String prodType;

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, Integer stock, String seller, String category, String subCategory, String pictureUrl, String fit, String material, String prodType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.category = category;
        this.subCategory = subCategory;
        this.pictureUrl = pictureUrl;
        this.fit=fit;
        this.material=material;
        this.prodType=prodType;

    }

    public Product() {
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

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getSubCategory(){
        return subCategory;
    }

    public void setSubCategory(String subCategory){
        this.subCategory = subCategory;
    }

    public String getSeller(){
        return seller;
    }

    public void setSeller(String seller){
        this.seller = seller;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

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
}

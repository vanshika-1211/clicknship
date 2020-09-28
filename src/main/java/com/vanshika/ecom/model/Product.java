package com.vanshika.ecom.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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


    public Product(Long id, @NotNull(message = "Product name is required") String name, Double price, Integer stock, String seller, String category, String subCategory, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.category = category;
        this.subCategory = subCategory;
        this.pictureUrl = pictureUrl;
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

}

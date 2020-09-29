package com.vanshika.ecom.service;


import com.vanshika.ecom.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();
    Iterable<Product> findUsingName(String name);
    Iterable<Product> findUsingId(Long id);
    Product findProductUsingId(Long id);
    Iterable<Product> findUsingCategory(String category);
    Iterable<Product> findUsingSubCategory(String subCategory);
    Iterable<Product> findUsingCategoryAndSubCategory(String category, String subCategory);
    Iterable<Product> findUsingSellerAndProductType(String seller, String prodType);
    Iterable<Product> findUsingSellerAndCategoryAndProductType(String seller, String category, String prodType);
}

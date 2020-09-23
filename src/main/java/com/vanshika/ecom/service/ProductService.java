package com.vanshika.ecom.service;


import com.vanshika.ecom.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();
    String findUsingName(String name);
    String findUsingCategory(String category);
    String findUsingSubCategory(String subCategory);
    String findUsingCategoryAndSubCategory(String category, String subCategory);
}

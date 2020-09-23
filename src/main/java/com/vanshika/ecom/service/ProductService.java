package com.vanshika.ecom.service;


import com.vanshika.ecom.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();
    String findByName(String name);
    String findByCategory(String category);
    String findBySubCategory(String subCategory);
    String findByCategoryAndSubCategory(String category, String subCategory);
}

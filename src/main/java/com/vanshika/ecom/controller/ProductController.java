package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.ProductService;
import com.vanshika.ecom.service.ProductServiceImplem;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    private final ProductService productService;
    
    @Autowired
    private ProductServiceImplem service;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/search/name")
    public Product searchByName(@org.jetbrains.annotations.NotNull @RequestBody Product product) {
        String prodName=product.getName();
        Product prodObj;
        prodObj=service.fetchByName(prodName);
        return prodObj;
    }

    @PostMapping("/search/category")
    public Product searchByCategory(@org.jetbrains.annotations.NotNull @RequestBody Product product) {
        String prodCat=product.getCategory();
        Product prodObj;
        prodObj=service.fetchByCategory(prodCat);
        return prodObj;
    }

    @PostMapping("/search/sub-category")
    public Product searchBySubCategory(@org.jetbrains.annotations.NotNull @RequestBody Product product) {
        String prodSubCat=product.getSubCategory();
        Product prodObj;
        prodObj=service.fetchBySubCategory(prodSubCat);
        return prodObj;
    }

    @PostMapping("/search/category-sub-category")
    public Product searchByCategoryAndSubCategory(@org.jetbrains.annotations.NotNull @RequestBody Product product) {
        String prodCat=product.getCategory();
        String prodSubCat=product.getSubCategory();
        Product prodObj;
        prodObj=service.fetchByCategoryAndSubCategory(prodCat,prodSubCat);
        return prodObj;
    }

    @PostMapping("/search/seller")
    public Product searchBySeller(@org.jetbrains.annotations.NotNull @RequestBody Product product) {
        String prodSeller=product.getSeller();
        Product prodObj=service.fetchBySeller(prodSeller);
        return prodObj;
    }
}

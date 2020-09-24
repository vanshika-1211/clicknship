package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.ProductNotFoundException;
import com.vanshika.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> list=productService.getAllProducts();
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productName/{name}")
    public ResponseEntity<Iterable<Product>> getByName(@PathVariable String name) {
        Iterable<Product> list = productService.findUsingName(name);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productCategory/{category}")
    public ResponseEntity<Iterable<Product>> getByCategory(@PathVariable String category) {
        Iterable<Product> list = productService.findUsingCategory(category);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productSubCategory/{subCategory}")
    public ResponseEntity<Iterable<Product>> getBySubCategory(@PathVariable String subCategory) {
        Iterable<Product> list = productService.findUsingSubCategory(subCategory);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productCategory/{cat}/ProductSubCategory/{subCat}")
    public ResponseEntity<Iterable<Product>> getByCategoryAndSubCategory(@PathVariable("cat") String category, @PathVariable("subCat") String subCategory) {
        Iterable<Product> list = productService.findUsingCategoryAndSubCategory(category, subCategory);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

}

package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> list=productService.getAllProducts();
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productName/{name}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByName(@PathVariable String name) {
        Iterable<Product> list = productService.findUsingName(name);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productCategory/{category}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByCategory(@PathVariable String category) {
        Iterable<Product> list = productService.findUsingCategory(category);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productSubCategory/{subCategory}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getBySubCategory(@PathVariable String subCategory) {
        Iterable<Product> list = productService.findUsingSubCategory(subCategory);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/productCategory/ProductSubCategory/{cat}/{subCat}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByCategoryAndSubCategory(@PathVariable("cat") String category, @PathVariable("subCat") String subCategory) {
        Iterable<Product> list = productService.findUsingCategoryAndSubCategory(category, subCategory);
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

}

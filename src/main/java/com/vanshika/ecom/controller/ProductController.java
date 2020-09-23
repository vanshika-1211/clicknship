package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.ProductNotFoundException;
import com.vanshika.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> list=productService.getAllProducts();
        return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/{name}/productNames")
    public ResponseEntity<String> getByName(@PathVariable String name) {
        Optional<String> opt = Optional.ofNullable(productService.findByName(name));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

    @GetMapping("/{category}/productCategory")
    public ResponseEntity<String> getByCategory(@PathVariable String category) {
        Optional<String> opt = Optional.ofNullable(productService.findByCategory(category));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

    @GetMapping("/{subCategory}/productSubCategory")
    public ResponseEntity<String> getBySubCategory(@PathVariable String subCategory) {
        Optional<String> opt = Optional.ofNullable(productService.findBySubCategory(subCategory));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/productCategoryAndSubCategory")
    public ResponseEntity<String> getByCategoryAndSubCategory(@PathVariable("id") String category, String subCategory) {
        Optional<String> opt = Optional.ofNullable(productService.findByCategoryAndSubCategory(category, subCategory));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

}

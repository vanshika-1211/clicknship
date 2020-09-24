package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.ProductNotFoundException;
import com.vanshika.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{name}/productNames")
    public ResponseEntity<String> getByName(@PathVariable String name) {
        Optional<String> opt = Optional.ofNullable(productService.findUsingName(name));
         String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

    @GetMapping("/{category}/productCategory")
    public ResponseEntity<String> getByCategory(@PathVariable String category) {
        Optional<String> opt = Optional.ofNullable(productService.findUsingCategory(category));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

    @GetMapping("/{subCategory}/productSubCategory")
    public ResponseEntity<String> getBySubCategory(@PathVariable String subCategory) {
        Optional<String> opt = Optional.ofNullable(productService.findUsingSubCategory(subCategory));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

    @GetMapping("/{cat}/{subCat}/productCategoryAndSubCategory")
    public ResponseEntity<String> getByCategoryAndSubCategory(@PathVariable("cat") String category,@PathVariable("subCat") String subCategory) {
        Optional<String> opt = Optional.ofNullable(productService.findUsingCategoryAndSubCategory(category, subCategory));
        String list = opt.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }

}

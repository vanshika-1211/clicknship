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
    public ResponseEntity<Iterable<Product>> getByName(@PathVariable String name) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingName(name);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productId/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getById(@PathVariable Long id) throws ProductNotFoundException {
        try {
            Iterable<Product> list = (Iterable<Product>) productService.findUsingId(id);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productCategory/{category}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByCategory(@PathVariable String category) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingCategory(category);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productSellerUsername/{sellerUsername}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getBySellerUsername(@PathVariable String sellerUsername) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingSellerUsername(sellerUsername);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productSubCategory/{subCategory}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getBySubCategory(@PathVariable String subCategory) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingSubCategory(subCategory);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productCategory/productSubCategory/{cat}/{subCat}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByCategoryAndSubCategory(@PathVariable("cat") String category, @PathVariable("subCat") String subCategory) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingCategoryAndSubCategory(category, subCategory);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productSeller/productType/{seller}/{prodType}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getBySellerAndProductType(@PathVariable String seller, @PathVariable String prodType) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingSellerAndProductType(seller, prodType);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productSeller/productCategory/productType/{seller}/{category}/{prodType}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByCategoryAndSubCategory(@PathVariable String seller, @PathVariable String category, @PathVariable String prodType) throws ProductNotFoundException{
        try {
            Iterable<Product> list = productService.findUsingSellerAndCategoryAndProductType(seller, category, prodType);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }

    }
}

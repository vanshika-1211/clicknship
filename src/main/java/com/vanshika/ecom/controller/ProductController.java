package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.repository.ProductRepository;
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
    private ProductRepository productRepository;

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

    @GetMapping("/productType/{prodType}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByProductType(@PathVariable String prodType) throws ProductNotFoundException {
        try {
            Iterable<Product> list = productService.findUsingProductType(prodType);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/productCategory/productType/{category}/{prodType}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Product>> getByCategoryAndProductType(@PathVariable String category, @PathVariable String prodType) throws ProductNotFoundException{
        try {
            Iterable<Product> list = productService.findUsingCategoryAndProductType(category, prodType);
            return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ProductNotFoundException();
        }
    }

    @PostMapping("/addProduct")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void createProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/getSellerProduct/{username}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Product> getSellerProducts(@PathVariable("username") String sellerUsername) throws ProductNotFoundException {
        try {
            return productService.findByUsername(sellerUsername);
        } catch (Exception e) {
            throw new ProductNotFoundException();
        }
    }
}


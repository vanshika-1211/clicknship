package com.vanshika.ecom.queryResolver;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.repository.ProductRepository;
import com.vanshika.ecom.service.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query {
    private ProductRepository productRepository;

    public Query(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public String findUsingName(String name) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findUsingName(name));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public String findUsingCategory(String category) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findUsingCategory(category));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public String findUsingSubCategory(String subCategory) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findUsingSubCategory(subCategory));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public String findUsingCategoryAndSubCategory(String category, String subCategory) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findUsingCategoryAndSubCategory(category, subCategory));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

}

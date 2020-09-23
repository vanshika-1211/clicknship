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

    public String findByName(String name) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findByName(name));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public String findByCategory(String category) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findByCategory(category));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public String findBySubCategory(String subCategory) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findBySubCategory(subCategory));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public String findByCategoryAndSubCategory(String category, String subCategory) {
        Optional<String> productOptional = Optional.ofNullable(productRepository.findByCategoryAndSubCategory(category, subCategory));
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

}

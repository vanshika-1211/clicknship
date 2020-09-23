package com.vanshika.ecom.service;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImplem implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImplem(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String findUsingName(String name) {
        return (String) productRepository.findUsingName(name);
    }

    @Override
    public String findUsingCategory(String category) {
        return (String) productRepository.findUsingCategory(category);
    }

    @Override
    public String findUsingSubCategory(String subCategory) {
        return (String) productRepository.findUsingSubCategory(subCategory);
    }

    @Override
    public String findUsingCategoryAndSubCategory(String category, String subCategory) {
        return (String) productRepository.findUsingCategoryAndSubCategory(category, subCategory);
    }

}


package com.vanshika.ecom.service;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImplem implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplem(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String findByName(String name) {
        return (String) productRepository.findByName(name);
    }

    @Override
    public String findByCategory(String category) {
        return (String) productRepository.findByCategory(category);
    }

    @Override
    public String findBySubCategory(String subCategory) {
        return (String) productRepository.findBySubCategory(subCategory);
    }

    @Override
    public String findByCategoryAndSubCategory(String category, String subCategory) {
        return (String) productRepository.findByCategoryAndSubCategory(category, subCategory);
    }

}


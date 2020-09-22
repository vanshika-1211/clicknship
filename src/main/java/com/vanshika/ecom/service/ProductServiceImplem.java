package com.vanshika.ecom.service;

import com.vanshika.ecom.exception.ResourceNotFoundException;
import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImplem implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImplem(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product fetchByName(String name){
        return productRepository.findByName(name);
    }

    public Product fetchByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public Product fetchBySubCategory(String subCategory){
        return productRepository.findBySubCategory(subCategory);
    }

    public Product fetchByCategoryAndSubCategory(String category, String subCategory){
        return productRepository.findByCategoryAndSubCategory(category, subCategory);
    }

    public Product fetchBySeller(String seller){
        return productRepository.findBySeller(seller);
    }

}

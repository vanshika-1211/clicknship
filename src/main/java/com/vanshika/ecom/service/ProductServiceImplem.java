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
    public Iterable<Product> findUsingName(String name) {
        return productRepository.findUsingName(name);
    }

    @Override
    public Iterable<Product> findUsingId(Long id) {
        return productRepository.findUsingId(id);
    }

    @Override
    public Product findProductUsingId(Long id) {
        return productRepository.findProductUsingId(id);
    }

    @Override
    public Iterable<Product> findUsingCategory(String category) {
        return productRepository.findUsingCategory(category);
    }

    @Override
    public Iterable<Product> findUsingSellerUsername(String sellerUsername) {
        return productRepository.findUsingSellerUsername(sellerUsername);
    }

    @Override
    public Iterable<Product> findUsingSubCategory(String subCategory) {
        return productRepository.findUsingSubCategory(subCategory);
    }

    @Override
    public Iterable<Product> findUsingCategoryAndSubCategory(String category, String subCategory) {
        return productRepository.findUsingCategoryAndSubCategory(category, subCategory);
    }

    @Override
    public Iterable<Product> findUsingProductType(String prodType) {
        return productRepository.findUsingProductType(prodType);
    }

    @Override
    public Iterable<Product> findUsingCategoryAndProductType(String category, String prodType) {
        return productRepository.findUsingCategoryAndProductType(category, prodType);
    }

    @Override
    public Iterable<Product> findByUsername(String sellerUsername) {
        return productRepository.findByUsername(sellerUsername);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

}


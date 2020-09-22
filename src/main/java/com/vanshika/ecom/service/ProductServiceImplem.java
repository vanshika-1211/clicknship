package com.vanshika.ecom.service;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import java.util.Optional;

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
    public Optional<Product> getProduct(@Min(value = 1L, message = "Invalid product ID.") long id) {
        return productRepository
                .findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}


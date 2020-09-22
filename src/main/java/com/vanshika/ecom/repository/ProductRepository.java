package com.vanshika.ecom.repository;

import com.vanshika.ecom.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}


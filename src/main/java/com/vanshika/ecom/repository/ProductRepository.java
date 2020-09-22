package com.vanshika.ecom.repository;

import com.vanshika.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{


    Product findByName(String name);

    Product findByCategory(String category);

    Product findBySubCategory(String subCategory);

    Product findByCategoryAndSubCategory(String category, String subCategory);

    Product findBySeller(String seller);
}

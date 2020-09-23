package com.vanshika.ecom.repository;

import com.vanshika.ecom.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select p from Product p where p.name=:name")
    String findByName(String name);

    @Query("select p from Product p where p.category=:category")
    String findByCategory(String category);

    @Query("select p from Product p where p.subCategory=:subCategory")
    String findBySubCategory(String subCategory);

    @Query("select p from Product p where p.category=:category and p.subCategory=:subCategory")
    String findByCategoryAndSubCategory(String category, String subCategory);

}


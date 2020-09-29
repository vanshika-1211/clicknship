package com.vanshika.ecom.repository;

import com.vanshika.ecom.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.name=:name")
    Iterable<Product> findUsingName(String name);

    @Query("select p from Product p where p.id=:id")
    Iterable<Product> findUsingId(Long id);

    @Query("select p from Product p where p.category=:category")
    Iterable<Product> findUsingCategory(String category);

    @Query("select p from Product p where p.subCategory=:subCategory")
    Iterable<Product> findUsingSubCategory(String subCategory);

    @Query("select p from Product p where p.category=:category and p.subCategory=:subCategory")
    Iterable<Product> findUsingCategoryAndSubCategory(String category, String subCategory);

    @Query("select p from Product p where p.seller=:seller and p.prodType=:prodType")
    Iterable<Product> findUsingSellerAndProductType(String seller, String prodType);

    @Query("select p from Product p where p.seller=:seller and p.category=:category and p.prodType=:prodType")
    Iterable<Product> findUsingSellerAndCategoryAndProductType(String seller, String category, String prodType);

    @Transactional
    @Modifying
    @Query("update Product p set p.stock=:stock where p.name=:name and p.seller=:seller and p.category=:category and p.subCategory=:subCategory")
    void updateProductInfo(String name, String seller, String category, String subCategory);

}


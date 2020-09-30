package com.vanshika.ecom.repository;

import com.vanshika.ecom.model.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SellerRepository extends CrudRepository<Seller,Long> {

    @Query("select s from Seller s where s.sellerUsername=:sellerUsername")
    List<Seller> findByUsername(String sellerUsername);

    @Query("select s from Seller s where s.id=:id")
    Seller findProductById(Long id);
}

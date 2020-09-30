package com.vanshika.ecom.service;

import com.vanshika.ecom.model.Seller;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface SellerService {
    List<Seller> findByUsername(String sellerUsername);
    Seller FindProductById(Long id);
}

package com.vanshika.ecom.service;

import com.vanshika.ecom.model.Seller;
import com.vanshika.ecom.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SellerServiceImplem implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> findByUsername(String sellerUsername) {
        return sellerRepository.findByUsername(sellerUsername);
    }

    @Override
    public Seller FindProductById(Long id) {
        return sellerRepository.findProductById(id);
    }

}

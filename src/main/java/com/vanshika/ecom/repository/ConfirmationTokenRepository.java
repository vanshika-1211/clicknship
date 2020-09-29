package com.vanshika.ecom.repository;

import com.vanshika.ecom.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
    ConfirmationToken findByTokenId(long tokenId);
}


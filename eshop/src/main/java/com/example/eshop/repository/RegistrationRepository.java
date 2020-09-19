package com.example.eshop.repository;

import com.example.eshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
    User findByEmailId(String emailId);
    User findByEmailIdAndPassword(String emailId, String password);
}

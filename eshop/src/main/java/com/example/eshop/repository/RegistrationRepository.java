package com.example.eshop.repository;

import com.example.eshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}

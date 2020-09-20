package com.example.eshop.service;

import com.example.eshop.model.User;
import com.example.eshop.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class RegistrationService{
    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user){
        user.setPassword(getEncodedString(user.getPassword()));
        user.setConfirmPassword(getEncodedString(user.getConfirmPassword()));
        user.setEnabled(false);
        return repo.save(user);
    }

    public User fetchUserByEmailId(String email){
        return repo.findByEmailId(email);
    }

    public User fetchUserByEmailIdAndPassword(String email, String password){
        return repo.findByEmailIdAndPassword(email, password);
    }

    private String getEncodedString(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}

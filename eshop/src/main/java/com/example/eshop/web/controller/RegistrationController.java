package com.example.eshop.web.controller;

import com.example.eshop.model.User;
import com.example.eshop.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;


@RestController
@Validated
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    //@CrossOrigin
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPassword = user.getPassword();
        String tempConfirmPassword = user.getConfirmPassword();
        if(tempEmailId != null && !"".equals(tempEmailId)){
            User userObj = service.fetchUserByEmailId(tempEmailId);

           if(userObj != null){
               throw new Exception("user with " + tempEmailId + "already exists");
            }
        }
        if(tempPassword.equals(tempConfirmPassword)){
            User userObj = null;
            userObj = service.saveUser(user);
            return userObj;
        }
        else{
            throw new Exception("Password must match");
        }
    }
    @PostMapping("/login")
    //@CrossOrigin
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPass = getEncodedString(user.getPassword());

        User userObj = null;
        if(tempEmailId != null && tempPass != null){
               userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
        }
        if(userObj == null) throw new Exception("Bad Credentials");
        else{
           userObj.setEnabled(true);
            return userObj;
        }

    }

    private String getEncodedString(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}

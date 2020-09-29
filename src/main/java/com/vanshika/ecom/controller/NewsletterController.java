package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.AuthenticationRequest;
import com.vanshika.ecom.model.User;
import com.vanshika.ecom.service.NewsletterService;
import com.vanshika.ecom.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewsletterController{

    AuthenticationRequest authenticationRequest;

    NewsletterService newsletterService;

    RegistrationService registrationService;

    @PostMapping("/addService")
    public ResponseEntity<String> addNewsletterService(@RequestBody Map<String,String>user) throws Exception {
        try {
            String username=authenticationRequest.getUsername();
            User u=registrationService.fetchUserByUsername(username);
            if (u.isNewsletterService()) {
                return new ResponseEntity<String>("You are already subscribed to our newsletter.", HttpStatus.OK);
            }
            u.setNewsletterService(true);
            newsletterService.sendNewsletter(u, true);
            return new ResponseEntity<String>("You have been added successfully to ClickNShip's Newsletter service.", HttpStatus.OK);
        }
        catch (UsernameNotFoundException u){
            return new ResponseEntity<String>(u.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/removeService")
    public ResponseEntity<String> removeNewsletterService(@RequestBody Map<String,String>user){
        try{
            String username=authenticationRequest.getUsername();
            User u=registrationService.fetchUserByUsername(username);
            u.setNewsletterService(false);
            newsletterService.sendNewsletter(u, false);
            return new ResponseEntity<String>("You have been removed successfully from ClickNShip's Newsletter service.",HttpStatus.OK);
        }
        catch (UsernameNotFoundException u){
            return new ResponseEntity<String>(u.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}












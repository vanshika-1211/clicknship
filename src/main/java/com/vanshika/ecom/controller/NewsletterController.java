package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.AuthenticationRequest;
import com.vanshika.ecom.model.User;
import com.vanshika.ecom.repository.RegistrationRepository;
import com.vanshika.ecom.service.NewsletterService;
import com.vanshika.ecom.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NewsletterController {


    @Autowired
    private NewsletterService newsletterService;

    @Autowired
    private RegistrationService service;

    @Autowired
    private RegistrationRepository userRepo;

    @GetMapping("/addService/{username}")
    public ResponseEntity<String> addNewsletterService(@PathVariable String username) throws Exception {
        User user = service.fetchUserByUsername(username);
        if(user == null){
            throw new Exception("Username does not exist!");
        }
        if (user.isNewsletterService()) {
            return new ResponseEntity<String>("You are already subscribed to our newsletter.", HttpStatus.OK);
        }
        user.setNewsletterService(true);
        userRepo.save(user);
        newsletterService.sendNewsletter(user, true);
        return new ResponseEntity<String>("You have been added successfully to ClickNShip's Newsletter service.", HttpStatus.OK);

    }

   @GetMapping("/removeService/{username}")
    public ResponseEntity<String> removeNewsletterService(@PathVariable String username) throws Exception{
        User user = service.fetchUserByUsername(username);
        if(user == null){
            throw new Exception("username does not exist!");
        }
        user.setNewsletterService(false);
        userRepo.save(user);
        newsletterService.sendNewsletter(user, false);
        return new ResponseEntity<String>("You have been removed successfully from ClickNShip's Newsletter service.",HttpStatus.OK);

    }
}













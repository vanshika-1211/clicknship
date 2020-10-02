package com.vanshika.ecom.controller;

import com.vanshika.ecom.repository.RegistrationRepository;
import com.vanshika.ecom.service.NewsletterService;
import com.vanshika.ecom.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsletterController {


    @Autowired
    private NewsletterService newsletterService;

    @Autowired
    private RegistrationService service;

    @Autowired
    private RegistrationRepository userRepo;

    @GetMapping("/addService/{username}")
    public ResponseEntity<String> addNewsletterService(@PathVariable String username){
        newsletterService.sendNewsletter(username);
        return new ResponseEntity<String>("You have been added successfully to ClickNShip's Newsletter service.", HttpStatus.OK);

    }
}













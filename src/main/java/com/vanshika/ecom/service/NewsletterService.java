package com.vanshika.ecom.service;

import com.vanshika.ecom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {
    @Autowired
    EmailService emailService;
    SimpleMailMessage mailMessage = new SimpleMailMessage();

    public void sendNewsletter(String username){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(username);
        mailMessage.setSubject("Subscription for Newsletter");
        mailMessage.setFrom("gomailsender@gmail.com");
        mailMessage.setText("Thank you for subscribing to our newsletter! You will be now be updated regarding our offers and amazing discounts.\n\n\n\nRegards: @Team ClickNShip");
        emailService.sendEmail(mailMessage);
    }

}

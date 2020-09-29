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

    public void sendNewsletter(User user, boolean status){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUsername());
        mailMessage.setSubject("Subscription for Newsletter");
        mailMessage.setFrom("gomailsender@gmail.com");
        if(status){
            mailMessage.setText("Thank you for subscribing to our newsletter!  Regards: Team ClickNShip");
        }
        else{
            mailMessage.setText("You have successfully unsubscribed from ClickNShip's newsletter.  Regards: Team ClickNShip");
        }

        emailService.sendEmail(mailMessage);
    }

}

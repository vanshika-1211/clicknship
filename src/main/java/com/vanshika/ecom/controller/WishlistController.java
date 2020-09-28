package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.User;
import com.vanshika.ecom.model.WishlistRequest;
import com.vanshika.ecom.repository.ProductRepository;
import com.vanshika.ecom.repository.RegistrationRepository;
import com.vanshika.ecom.service.ProductServiceImplem;
import com.vanshika.ecom.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private RegistrationRepository userRepo;

    @Autowired
    private RegistrationService service;

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private ProductServiceImplem prodService;

   @PostMapping("/addToWishlist")
   @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<String> addToWishlist(@RequestBody WishlistRequest wishReq){
       String username = wishReq.getUsername();
       String prodId = wishReq.getProductId();

       User user = service.fetchUserByUsername(username);
       user.setWishlist(user.getWishlist() + prodId + ";");
       userRepo.save(user);

       return stringToList(user.getWishlist());
   }

   @GetMapping("/myWishlist/{username}")
   @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<String>> myWishlist(@PathVariable String username){
       User user = service.fetchUserByUsername(username);

       List<String> list = stringToList(user.getWishlist());
       return new ResponseEntity<List<String>>(list, HttpStatus.OK);
   }

   @PostMapping("/removeFromWishlist")
   @CrossOrigin(origins = "*", allowedHeaders = "*")
   public List<String> removeFromWishlist(@RequestBody WishlistRequest wishReq){
       String username = wishReq.getUsername();
       String prodId = wishReq.getProductId();

       User user = service.fetchUserByUsername(username);

       String str = user.getWishlist();
       int l = str.length();
       String s = "", str1 = "";
       List<String> list = new ArrayList<>();
       for (int i = 0; i < l; i++){
           if(str.charAt(i) == ';'){
               if(s.equals(prodId)){
                   s = "";
               }
               else{
                   str1 += s + ";";
                   s = "";
               }
           }
           else{
               s += str.charAt(i);
           }
       }
       user.setWishlist(str1);
       userRepo.save(user);
       return stringToList(user.getWishlist());
   }

    @PostMapping("/doesProductExist")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public boolean doesProductExist(@RequestBody WishlistRequest wishReq){
        String username = wishReq.getUsername();
        String prodId = wishReq.getProductId();

        User user = service.fetchUserByUsername(username);

        String str = user.getWishlist();
        int l = str.length(), c = 0;
        String s = "";
        for (int i = 0; i < l; i++){
            if(str.charAt(i) == ';'){
                if(s.equals(prodId)){
                    s = "";
                    c = 1;
                    break;
                }
                else{
                    s = "";
                }
            }
            else{
                s += str.charAt(i);
            }
        }
        if(c == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public List<String> stringToList(String str){
       int l = str.length();
       String s = "";
       List<String> list = new ArrayList<>();
       for (int i = 0; i < l; i++){
           if(str.charAt(i) == ';'){
               list.add(s);
               s = "";
           }
           else{
               s += str.charAt(i);
           }
       }
       return list;
   }
}

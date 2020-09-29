package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.CartRequest;
import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.model.User;
import com.vanshika.ecom.repository.ProductRepository;
import com.vanshika.ecom.repository.RegistrationRepository;
import com.vanshika.ecom.service.EmailService;
import com.vanshika.ecom.service.ProductServiceImplem;
import com.vanshika.ecom.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    private RegistrationRepository userRepo;

    @Autowired
    private RegistrationService service;

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private ProductServiceImplem prodService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/addToCart")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<String> addToCart(@RequestBody CartRequest cartReq) throws Exception{
        String username = cartReq.getUsername();
        String prodId = cartReq.getProductId();
        String prodAmt = cartReq.getProductAmt();    //quantity of each prod;
        Long id = Long.parseLong(prodId);            //converting prod id to string
        Double amt = Double.parseDouble(prodAmt);    //converting quantity of products to double

        User user = service.fetchUserByUsername(username);   //finding user with this username
        Product product = prodService.findProductUsingId(id);       //finding product with this id

        if(amt > product.getStock()){
            throw new Exception("Product Out of Stock! Stock remaining:" + product.getStock());
        }
        String cart = user.getCart();
        String cartProd = user.getCartProdAmt();

        // to find if that product id is already present
        int l = cart.length(), c = 0, cnt = 0;
        String s = "";
        for (int i = 0; i < l; i++){
            if(cart.charAt(i) == ';'){
                if(s.equals(prodId)){
                    c = 1;
                    break;
                }
                else{
                    cnt += 1;
                }
                s = "";
            }
            else{
                s += cart.charAt(i);
            }
        }

        //if present, updating quantity of already present prod id
        if(c == 1){
            int cnt1 = 0, l1 = cartProd.length();
            String s1 = "",str1 = "";
            double ba = user.getBillingAmt();
            for(int i = 0; i < l1; i++){
                if(cartProd.charAt(i) == ';'){
                    if(cnt1 == cnt) {
                        ba -= (Double.parseDouble(s1))*(product.getPrice());
                        ba += amt*(product.getPrice());
                        str1 += prodAmt + ";";
                    }
                    else str1 += s1 + ";";
                    s1 = "";
                    cnt1 += 1;
                }
                else s1 += cartProd.charAt(i);
            }
            user.setCartProdAmt(str1);
            user.setBillingAmt(ba);
        }

        //if not present, storing the entered id
        else{
            user.setCart(user.getCart() + prodId + ";");
            user.setCartProdAmt(user.getCartProdAmt() + prodAmt + ";");
            user.setBillingAmt(amt*(product.getPrice()) + user.getBillingAmt());
        }

        userRepo.save(user);

        List<String> listOfProdId = stringToList(user.getCart());
        List<String> listOfProdAmt = stringToList(user.getCartProdAmt());

        List<String> list = new ArrayList<>();
        for(int i = 0; i< listOfProdId.size(); i++){
            list.add(listOfProdId.get(i) + "-" + listOfProdAmt.get(i));
        }
        String s2 = String.valueOf(user.getBillingAmt());
        list.add(s2);
        return list;
    }

    @GetMapping("/myCart/{username}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<String>> myCart(@PathVariable String username){
        User user = service.fetchUserByUsername(username);

        List<String> listOfProdId = stringToList(user.getCart());
        List<String> listOfProdAmt = stringToList(user.getCartProdAmt());

        List<String> list = new ArrayList<>();
        for(int i = 0; i< listOfProdId.size(); i++){
            list.add(listOfProdId.get(i) + "-" + listOfProdAmt.get(i));
        }
        String s = String.valueOf(user.getBillingAmt());
        list.add(s);

        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

   @PostMapping("removeFromCart")
   @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<String> removeFromWishlist(@RequestBody CartRequest cartReq) {
        String username = cartReq.getUsername();
        String prodId = cartReq.getProductId();
        String prodAmt = cartReq.getProductAmt();
        Long id = Long.parseLong(prodId);
        Double amt = Double.parseDouble(prodAmt);

        User user = service.fetchUserByUsername(username);
        Product product = prodService.findProductUsingId(id);

       String cart = user.getCart();
       String cartProd = user.getCartProdAmt();

       //updating quantity of each product in cart
       int l = cart.length(), c = 0, cnt = 0;
       String s = "", str = "";
       for (int i = 0; i < l; i++){
           if(cart.charAt(i) == ';'){
               if(s.equals(prodId)){
                   s = "";
                   c = 1;
               }
               else{
                   if(c == 0) cnt += 1;
                   str += s + ";";
                   s = "";
               }
           }
           else{
               s += cart.charAt(i);
           }
       }
       //updating quantity of each product in cart
       int cnt1 = 0, l1 = cartProd.length();
       String s1 = "",str1 = "";
       double ba = user.getBillingAmt();
       for(int i = 0; i < l1; i++){
           if(cartProd.charAt(i) == ';'){
               if(cnt1 == cnt) {
                   ba -= (Double.parseDouble(s1))*(product.getPrice());
                   s1 = "";
               }
               else str1 += s1 + ";";
               s1 = "";
               cnt1 += 1;
           }
           else s1 += cartProd.charAt(i);
       }
       user.setCart(str);
       user.setCartProdAmt(str1);
       user.setBillingAmt(ba);
       userRepo.save(user);

       //returning strings as lists
       List<String> listOfProdId = stringToList(user.getCart());
       List<String> listOfProdAmt = stringToList(user.getCartProdAmt());
       int len = listOfProdId.size();

       List<String> list = new ArrayList<>();
       for(int i = 0; i < len; i++){
           list.add(listOfProdId.get(i) + "-" + listOfProdAmt.get(i));
       }
       String s2 = String.valueOf(user.getBillingAmt());
       list.add(s2);

       //returning final cart
       return list;
    }

    @GetMapping("/orderPlaced/{username}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> orderPlaced(@PathVariable String username){
        User user = service.fetchUserByUsername(username);

        List<String> listOfProdId = stringToList(user.getCart());
        List<String> listOfProdAmt = stringToList(user.getCartProdAmt());
        int len = listOfProdId.size();

        for(int i = 0; i < len; i++){
            String prodId = listOfProdId.get(i);
            Long id = Long.parseLong(prodId);
            String prodAmt = listOfProdAmt.get(i);
            Integer amt = Integer.parseInt(prodAmt);

            Product product = prodService.findProductUsingId(id);
            product.setStock(product.getStock()-amt);
            prodRepo.save(product);
        }

        //sending mail when order has been placed successfully
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUsername());
        mailMessage.setSubject("Order Placed successful");
        mailMessage.setFrom("gomailsender@gmail.com");
        mailMessage.setText("Hello " + user.getFirstName() + "! ThankYou for shopping with us!! Your order has been successfully placed. Your total billing amount: $"
         + user.getBillingAmt() + " P.s. Your order wont be delivered to you due to delivery and payment issues. For further information contact our Customer Service. We hope to see you soon!");

        emailService.sendEmail(mailMessage);
        return ResponseEntity.ok("Your total bill amount is: " + user.getBillingAmt());
    }

    @PostMapping("/doesProductExistInCart")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public boolean doesProductExist(@RequestBody CartRequest cartReq) {
        String username = cartReq.getUsername();
        String prodId = cartReq.getProductId();

        User user = service.fetchUserByUsername(username);

        //finding if cart already contains the product
        String str = user.getCart();
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
        //if Yes
        if(c == 1){
            return true;
        }
        //if No
        else {
            return false;
        }
    }

    @PostMapping("/cartToWishlist")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<String> cartToWishlist(@RequestBody CartRequest cartReq){
        //removing from wishlist
        String username = cartReq.getUsername();
        String prodId = cartReq.getProductId();
        String prodAmt = cartReq.getProductAmt();
        Long id = Long.parseLong(prodId);
        Double amt = Double.parseDouble(prodAmt);

        User user = service.fetchUserByUsername(username);
        Product product = prodService.findProductUsingId(id);

        String cart = user.getCart();
        String cartProd = user.getCartProdAmt();

        //updating cart
        int l = cart.length(), c = 0, cnt = 0;
        String s = "", str = "";
        for (int i = 0; i < l; i++){
            if(cart.charAt(i) == ';'){
                if(s.equals(prodId)){
                    s = "";
                    c = 1;
                }
                else{
                    if(c == 0) cnt += 1;
                    str += s + ";";
                    s = "";
                }
            }
            else{
                s += cart.charAt(i);
            }
        }

        //updating quantity of each product in cart
        int cnt1 = 0, l1 = cartProd.length();
        String s1 = "",str1 = "";
        double ba = user.getBillingAmt();
        for(int i = 0; i < l1; i++){
            if(cartProd.charAt(i) == ';'){
                if(cnt1 == cnt) {
                    ba -= (Double.parseDouble(s1))*(product.getPrice());
                    s1 = "";
                }
                else str1 += s1 + ";";
                s1 = "";
                cnt1 += 1;
            }
            else s1 += cartProd.charAt(i);
        }
        user.setCart(str);
        user.setCartProdAmt(str1);
        user.setBillingAmt(ba);
        userRepo.save(user);

        //return strings as lists
        List<String> listOfProdId = stringToList(user.getCart());
        List<String> listOfProdAmt = stringToList(user.getCartProdAmt());
        int len = listOfProdId.size();

        List<String> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            list.add(listOfProdId.get(i) + "-" + listOfProdAmt.get(i));
        }
        String s2 = String.valueOf(user.getBillingAmt());
        list.add(s2);

        //adding product to wishlist
        user.setWishlist(user.getWishlist() + prodId + ";");
        userRepo.save(user);

        //return new cart
        return list;
    }

    //converting string to list
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

package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Seller;
import com.vanshika.ecom.repository.SellerRepository;
import com.vanshika.ecom.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/seller")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerService sellerService;

    //private byte[] bytes;

    /*@GetMapping("/getSellerProduct/{username}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Seller> getSellerProducts(@PathVariable("username") String sellerUsername){
        return sellerService.findByUsername(sellerUsername);
    }

   @PostMapping("/uploadImage")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }*/

    @PostMapping("/addProduct")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void createProduct(@RequestBody Seller seller){
       // seller.setPicByte(this.bytes);
        sellerRepository.save(seller);
       // this.bytes = null;
    }

    /*@DeleteMapping("/deleteProduct/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Seller deleteProduct(@PathVariable Long id) {
        Seller seller = sellerRepository.findProductById(id);
        sellerRepository.deleteById(id);
        return seller;
    }*/


}

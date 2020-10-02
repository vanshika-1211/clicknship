/*package com.vanshika.ecom.controller;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.DecompressorService;
import com.vanshika.ecom.service.ProductNotFoundException;
import com.vanshika.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;

@RestController
public class ImageRetrieve {

    @Autowired
    ProductService productService;

    @Autowired
    DecompressorService imageDecompress;

    @GetMapping(path = "/{name}/image")
    public String retrieveImage(@PathVariable String name)
            throws IOException, ProductNotFoundException, DataFormatException {
        Product product = (Product) productService.findUsingName(name);
        byte[] imageByte = imageDecompress.decompressImage(product.getPicByte());
        String image = Base64.getEncoder().encodeToString(imageByte);
        return image;
    }
}
*/
package com.vanshika.ecom.service;


import com.vanshika.ecom.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Optional<Product> getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);
}

package com.vanshika.ecom;

import com.vanshika.ecom.model.Product;
import com.vanshika.ecom.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
            productService.save(new Product(2L, "TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
            productService.save(new Product(3L, "TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
            productService.save(new Product(4L, "TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
            productService.save(new Product(5L, "TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
            productService.save(new Product(6L, "TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
            productService.save(new Product(7L,"TV Set", 300.00, 10, "Sony", "Electronics", "TV", "http://placehold.it/200x100"));
        };
    }
}
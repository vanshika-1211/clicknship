package com.vanshika.ecom;

import com.vanshika.ecom.controller.ProductController;
import com.vanshika.ecom.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EcommerceApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EcomApplicationIntegTest {
    @Autowired private TestRestTemplate restTemplate;

    @LocalServerPort private int port;

    @Autowired private ProductController productController;

    @Test
    public void contextLoads() {
        Assertions
                .assertThat(productController)
                .isNotNull();
    }

    @Test
    public void givenGetProductsApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<Iterable<Product>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Product>>() {
        });
        Iterable<Product> products = responseEntity.getBody();
        Assertions
                .assertThat(products)
                .hasSize(7);

        assertThat(products, hasItem(hasProperty("name", is("Women T-shirt"))));
        assertThat(products, hasItem(hasProperty("category", is("Men"))));
        assertThat(products, hasItem(hasProperty("name", is("Travel Trolley"))));
        assertThat(products, hasItem(hasProperty("subCategory", is("Top-wear"))));
        assertThat(products, hasItem(hasProperty("name", is("Girls Dress-set"))));
        assertThat(products, hasItem(hasProperty("name", is("Women Heels"))));
        assertThat(products, hasItem(hasProperty("name", is("Men Shoes"))));
    }
    }

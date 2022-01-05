package com.rb.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

/*
    @Bean
    public CommandLineRunner run(ProductRepository productRepository) {
        return (args -> {
            insertProducts(productRepository);
            System.out.println(productRepository.findAll());
        });
    }

    private void insertProducts(ProductRepository productRepository) {
        productRepository.save(new Product("Product 1", 123132, 10, 1));
        productRepository.save(new Product("Product 2", 123131, 20, 2));
    }

 */



}

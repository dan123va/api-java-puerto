package com.daniel.backend.controller;

import com.daniel.backend.document.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public Product getProducts() {
        
        Product product = new Product(
            "1",
            "Coca Cola",
            25.50
        );

        return product;
    }

}
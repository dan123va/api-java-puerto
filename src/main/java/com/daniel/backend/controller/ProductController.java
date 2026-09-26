package com.daniel.backend.controller;

import com.daniel.backend.document.Product;
import com.daniel.backend.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping
    public Product createProduct(
            @RequestBody Product product
    ) {
        return productService.save(product);
    }
}
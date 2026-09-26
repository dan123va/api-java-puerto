package com.daniel.backend.repository;

import com.daniel.backend.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository
        extends MongoRepository<Product, String> {

}
package com.daniel.backend.repository;

import com.daniel.backend.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository
        extends MongoRepository<Order, String> {

}
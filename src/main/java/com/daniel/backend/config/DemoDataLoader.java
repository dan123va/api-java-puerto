package com.daniel.backend.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.daniel.backend.document.Order;
import com.daniel.backend.document.OrderStatus;
import com.daniel.backend.document.User;
import com.daniel.backend.repository.OrderRepository;
import com.daniel.backend.repository.UserRepository;

@Configuration
public class DemoDataLoader {

    @Bean
    CommandLineRunner seed(
        UserRepository users,
        OrderRepository orders
    ) {
        return args -> {
            if (users.count() > 0) {
                return;
            }
            
            User a = users.save(
                new User(
                    "Mariana",
                    "García",
                    "López",
                    "mariana.garcia@example.com",
                    "Av. Universidad 1200, CDMX"
                )
            );

            User b = users.save(
                new User(
                    "Carlos",
                    "Hernández",
                    "Ruiz",
                    "carlos.hernandez@example.com",
                    "Calz. Independencia 455, Guadalajara"
                )
            );

            User c = users.save(
                new User(
                    "Sofía",
                    "Martínez",
                    "Díaz",
                    "sofia.martinez@example.com",
                    "Av. Constitución 890, Monterrey"
                )
            );

            orders.save(
                new Order(
                    a.getId(),
                    "Pedido Mariana",
                    "LIV-88341",
                    2,
                    new BigDecimal("1299.90"),
                    OrderStatus.EN_PREPARACION.name()
                )
            );

            orders.save(
                new Order(
                    b.getId(),
                    "Pedido Carlos",
                    "LIV-19720",
                    1,
                    new BigDecimal("8499.00"),
                    OrderStatus.ENVIADO.name()
                )
            );

            orders.save(
                new Order(
                    c.getId(),
                    "Pedido Sofía",
                    "LIV-55218",
                    3,
                    new BigDecimal("459.50"),
                    OrderStatus.ENTREGADO.name()
                )
            );
        };
    }
}
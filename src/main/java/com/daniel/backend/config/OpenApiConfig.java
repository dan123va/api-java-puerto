package com.daniel.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI liverpoolOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Puerto de Liverpool API")
                .description("API para administrar clientes y pedidos de Liverpool.")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Daniel")));
    }
}

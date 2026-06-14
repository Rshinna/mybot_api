package com.rshinna.mybot_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info =
        @Info(
            title = "Mybot API",
            version = "1.0",
            description =
                "API de chatbot desenvolvida para demonstrar padrões de projeto com Spring Boot",
            contact = @Contact(name = "Rodrigo Franco Jorge", email = "rshina@hotmail.com")))
public class OpenApiConfig {}

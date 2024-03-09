package com.example.autoservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Forecast API",
                description = "Forecast documentation api", version = "1.0.0",
                contact = @Contact(
                        name = "Roman",
                        email = "dcct0rlon@gmail.com",
                        url = "https://github.com/dcct0r"
                )
        )
)
public class OpenApiConfig {
}

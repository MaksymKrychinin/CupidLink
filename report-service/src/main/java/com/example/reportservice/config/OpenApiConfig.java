package com.example.reportservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
      info = @Info(
            contact = @Contact(
                  name = "Zakhar Zakharchuk",
                  email = "Zakhar_Zakharchuk@epam.com"
            ),
            description = "OpenApi documentation for CupidLink report service",
            title = "OpenApi specification for CupidLink"
      )
)
public class OpenApiConfig {

}

package com.learning.springboot3swaggerui.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "SpringBoot3 with swagger UI sample proj",
                version = "0.0.1",
                description = "It is just only for student learning",
                termsOfService = "Open Source",
                contact = @Contact(
                        name = "Arkar",
                        email = "arkarmoedev1994@gmail.com",
                        url = "https://github.com/arkarmoe17"
                ),
                license = @License(
                        name = "No License", url = "Nil"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080", description = "Local environment"
                ),
                @Server(
                        url = "http://localhost:8080", description = "DEV environment"
                ),
                @Server(
                        url = "http://localhost:8080", description = "PREPROD environment"
                ),
                @Server(
                        url = "http://localhost:8080", description = "PROD environment"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}

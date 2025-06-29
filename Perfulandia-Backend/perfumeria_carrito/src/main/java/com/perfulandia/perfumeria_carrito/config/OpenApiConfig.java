package com.perfulandia.perfumeria_carrito.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST Perfumeria Carrito")
                        .version("1.0.0")
                        .description("API REST para el manejo de un carrito de compras de perfumeria")
                        .contact(new Contact()
                                .name("Bayron baez")
                                .email("bay.baez@duocuc.cl")
                                .url("https://github.com/BayronAlexisBaezVargas")
                        )
                        .license(new License()
                                .name("Licencia MIT")
                                .url("https://opensource.org/licenses/MIT")
                        )
                );
    }
}

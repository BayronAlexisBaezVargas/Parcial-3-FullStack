package com.Inventario.Microservicio_Inventario.config;

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
                        .title("Inventario de perfulandiaSPA")
                        .version("1.0.0")
                        .description("Documentación de la API para la tienda de Perfulandia.")
                        .contact(new Contact()
                                .name("Natalia Paredes")
                                .email("na.paredesb@duocuc.cl")
                                .url("https://www.duoc.cl")
                        )

                );
    }
}

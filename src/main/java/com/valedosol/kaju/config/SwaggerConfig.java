package com.valedosol.kaju.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", createJwtSecurityScheme()))
                .info(createApiInfo());
    }
    
    private SecurityScheme createJwtSecurityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
    
    private Info createApiInfo() {
        return new Info()
                .title("Kaju Promo Sender API")
                .description("API para envio de promoções e gerenciamento de assinaturas do Kaju")
                .version("1.0")
                .contact(new Contact()
                        .name("Matheus Pereira")
                        .email("mdsp.personal@gmail.com")
                        .url("https://www.kaju.com"))
                .license(new License()
                        .name("API License")
                        .url("https://www.kaju.com/license"));
    }
}
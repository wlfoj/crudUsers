package com.example.crudUsers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                // Cliente 1, pode acessar qualquer endpoint
                //registry.addMapping("/**")
                //        .allowedOrigins("http://localhost:5000", "http://localhost:300")
                //        .allowedMethods("GET", "POST", "PUT", "DELETE");

                // Cliente 2, só pode acessar customer
                //registry.addMapping("/customer")
                //        .allowedOrigins("http://localhost:8084", "http://localhost:3000")
                //        .allowedMethods("GET", "POST", "PUT", "DELETE");

                // De qualquer site e pode acessar qualquer endpoint
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
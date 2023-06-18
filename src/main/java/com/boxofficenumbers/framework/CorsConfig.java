package com.boxofficenumbers.framework;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/users/{userName}/movie-selections")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(true)
                .maxAge(3600);

        registry.addMapping("/userSelections")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST") // Add more methods if needed
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(true)
                .maxAge(3600);

        registry.addMapping("/login")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("POST")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(true)
                .maxAge(3600);

    }
}

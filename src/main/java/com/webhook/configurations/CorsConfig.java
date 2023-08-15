package com.webhook.configurations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins(
                "https://testpartner.mhealth.ai",
                "https://partner.mhealth.ai",
                "https://www.mhealth.ai",
                "https://mhealth.ai",
                "https://testapi.mhealth.ai",
                "https://testapi.mhealth.ai:8081",
                "https://w21.mhealth.ai",
                "https://walkathon21.com",
                "https://www.nutriexpert.io",
                "http://testapi.mhealth.ai:8086",
                "http://testapi.mhealth.ai"
            )
            .allowedMethods("GET", "POST", "PUT", "OPTIONS")
            .allowedHeaders("*") // Allow all headers
            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            .maxAge(3600)
            .allowCredentials(true);
    }
}


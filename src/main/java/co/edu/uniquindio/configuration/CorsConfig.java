package co.edu.uniquindio.configuration;

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
                registry.addMapping("/api/v1/**") // Permite todas las rutas del API
                        .allowedOrigins("http://localhost:4200") // Origen permitido
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Métodos permitidos
                        .allowCredentials(true);
            }
        };
    }
}

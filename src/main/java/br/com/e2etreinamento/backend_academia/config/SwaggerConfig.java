package br.com.e2etreinamento.backend_academia.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI academiaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Backend Academia")
                        .description("Documentação da API do sistema para academia")
                        .version("1.0.0"));
    }
}
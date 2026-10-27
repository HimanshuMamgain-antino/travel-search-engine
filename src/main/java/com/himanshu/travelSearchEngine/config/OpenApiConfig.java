package com.himanshu.travelSearchEngine.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI travelSearchEngineOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Travel Search Engine API")
                        .description("Searches flights across suppliers (Tripjack, TBO) and returns their raw responses")
                        .version("v1"));
    }
}

package com.hyomee.clog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class SwaggerConfig {

    @Bean
    public OpenAPI ClogAPI() {
        Info info = new Info()
                .title("Clog API")
                .description("Clog API입니다.")
                .version("1.0.0");

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info);
    }
}
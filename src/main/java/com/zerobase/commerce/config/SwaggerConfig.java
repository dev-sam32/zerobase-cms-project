package com.zerobase.commerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("[ZB] 개인 프로젝트 - E-Commerce Project")
            .description("E-Commerce Project 백엔드 서비스 구현 프로젝트")
            .version("1.0.0")
        );
  }
}

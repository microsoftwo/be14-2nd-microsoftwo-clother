package com.microsoftwo.clother.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "CORE-SERVICE API 명세서",
        description = "USER-SERVICE를 제외한 기능들에 대한 API 명세서",
        version = "v1")
)

@Configuration
public class SwaggerConfig {
}

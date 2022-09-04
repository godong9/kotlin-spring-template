package com.gdgo.spring.template.api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

@Profile(value = ["local", "dev"])
class OpenApiConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI().info(Info().title("Kotlin Spring Template API"))
    }
}

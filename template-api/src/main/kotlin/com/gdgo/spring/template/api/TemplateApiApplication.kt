package com.gdgo.spring.template.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(TemplateApiConfig::class)
@SpringBootApplication(
    exclude = [
        ErrorMvcAutoConfiguration::class,
    ]
)
class TemplateApiApplication

fun main(args: Array<String>) {
    runApplication<TemplateApiApplication>(*args)
}

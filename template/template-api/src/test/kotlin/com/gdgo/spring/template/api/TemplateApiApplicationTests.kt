package com.gdgo.spring.template.api

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("local")
@Import(TemplateApiConfig::class)
@SpringBootTest
class TemplateApiApplicationTests {

    @Test
    fun contextLoads() {
    }
}

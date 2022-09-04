package com.gdgo.spring.template.api

import com.gdgo.spring.template.adapter.TemplateAdapterConfig
import com.gdgo.spring.template.api.config.OpenApiConfig
import org.springframework.context.annotation.Import

@Import(
    TemplateAdapterConfig::class,
    OpenApiConfig::class,
)
class TemplateApiConfig

package com.gdgo.spring.template.api

import com.gdgo.spring.template.adapter.TemplateAdapterConfig
import org.springframework.context.annotation.Import

@Import(
    TemplateAdapterConfig::class,
)
class TemplateApiConfig

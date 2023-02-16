package com.gdgo.spring.template.adapter

import com.gdgo.spring.template.adapter.config.AsyncConfig
import com.gdgo.spring.template.adapter.config.JpaConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@Import(
    AsyncConfig::class,
    JpaConfig::class,
)
@ComponentScan(
    basePackages = [
        "com.gdgo.spring.template.adapter",
        "com.gdgo.spring.template.application",
    ]
)
class TemplateAdapterConfig

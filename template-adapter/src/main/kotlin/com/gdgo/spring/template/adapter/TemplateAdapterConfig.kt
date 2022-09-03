package com.gdgo.spring.template.adapter

import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@ComponentScan(
    basePackages = [
        "com.gdgo.spring.template.adapter",
        "com.gdgo.spring.template.application",
    ]
)
class TemplateAdapterConfig

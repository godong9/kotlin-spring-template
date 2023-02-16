package com.gdgo.spring.template.grpc

import com.gdgo.spring.template.grpc.config.GrpcConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(GrpcConfig::class)
@SpringBootApplication
class TemplateGrpcApplication

fun main(args: Array<String>) {
    runApplication<TemplateGrpcApplication>(*args)
}

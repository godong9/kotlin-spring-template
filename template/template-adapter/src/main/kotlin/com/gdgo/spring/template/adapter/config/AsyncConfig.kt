package com.gdgo.spring.template.adapter.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor

@EnableConfigurationProperties(AsyncProperties::class)
class AsyncConfig(
    private val asyncProperties: AsyncProperties,
) {
    @Bean
    fun templateTaskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = asyncProperties.corePoolSize
        executor.maxPoolSize = asyncProperties.maxPoolSize
        executor.setQueueCapacity(asyncProperties.queueCapacity)
        executor.setThreadNamePrefix("template-async-")
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.AbortPolicy())
        executor.initialize()
        return executor
    }
}

@ConstructorBinding
@ConfigurationProperties(prefix = "async-task-executor")
class AsyncProperties(
    val corePoolSize: Int,
    val maxPoolSize: Int,
    val queueCapacity: Int,
)

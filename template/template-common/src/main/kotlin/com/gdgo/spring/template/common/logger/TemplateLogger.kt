package com.gdgo.spring.template.common.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface TemplateLogger {
    val logger: Logger get() = LoggerFactory.getLogger(this.javaClass)
}

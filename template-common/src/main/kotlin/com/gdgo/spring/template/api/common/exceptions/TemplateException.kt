package com.gdgo.spring.template.api.common.exceptions

class TemplateException(
    private val exceptionType: ExceptionType,
    private val throwable: Throwable? = null,
) : RuntimeException("${exceptionType.code} - ${exceptionType.message}", throwable)

enum class ExceptionType(
    val code: String,
    val message: String,
) {
    NOT_FOUND("NOT_FOUND", "Not found"),
    BAD_REQUEST("BAD_REQUEST", "Bad request"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Internal server error"),
    UNKNOWN("UNKNOWN", "Unknown"),
}

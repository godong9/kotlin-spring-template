package com.gdgo.spring.template.api.web.handler

import com.gdgo.spring.template.common.exceptions.ExceptionType
import com.gdgo.spring.template.common.logger.TemplateLogger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(basePackages = ["com.gdgo.spring.template.api.web"])
class ControllerExceptionHandler {
    private companion object : TemplateLogger

    @ExceptionHandler(
        MethodArgumentNotValidException::class,
        HttpMessageNotReadableException::class,
        MissingRequestHeaderException::class,
        MethodArgumentTypeMismatchException::class
    )
    fun handleBadRequestException(request: HttpServletRequest, exception: Exception): ResponseEntity<ExceptionResponse> {
        val exceptionType = ExceptionType.BAD_REQUEST
        logger.warn("BadRequestException occurred. ${request.method} ${request.requestURI} - error: ${exception.message}", exception)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ExceptionResponse(
                    exceptionType.code,
                    exceptionType.message,
                    exception.message
                )
            )
    }

    @ExceptionHandler(Exception::class)
    fun handleException(request: HttpServletRequest, exception: Exception): ResponseEntity<ExceptionResponse> {
        val exceptionType = ExceptionType.UNKNOWN
        logger.error("Exception occurred. ${request.method} ${request.requestURI} - error: ${exception.message}", exception)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ExceptionResponse(
                    exceptionType.code,
                    exceptionType.message,
                    exception.message
                )
            )
    }

    data class ExceptionResponse(
        val code: String,
        val message: String,
        val debug: String?
    )
}

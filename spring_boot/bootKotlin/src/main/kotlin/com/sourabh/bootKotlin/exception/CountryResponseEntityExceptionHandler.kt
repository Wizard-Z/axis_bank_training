package com.sourabh.bootKotlin.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class CountryResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {
@ExceptionHandler(CountryNotFoundException::class)
        open fun countryNotFound(exception: CountryNotFoundException): ResponseEntity<Any?> {
    val exceptionResponse = exception.message?.let { ExceptionResponse(it, LocalDateTime.now()) }
    return ResponseEntity<Any?>(exceptionResponse, HttpStatus.NOT_FOUND)
}
}
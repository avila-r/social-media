package com.avila.authentication.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

class InvalidTokenGenerationException(message: String) : RuntimeException(message)

class InvalidTokenSubmitException : RuntimeException("Unauthorized access")

@RestControllerAdvice class TokenExceptionHandler {

    data class ExceptionMessage (
        val status: HttpStatus,
        val reason: String
    )

    @ExceptionHandler(InvalidTokenGenerationException::class)
    fun handleInvalidTokenGeneration(e: InvalidTokenGenerationException): ResponseEntity<ExceptionMessage> {

        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val headers = HttpHeaders()

        headers.add("Content-Type", "application/json")
        headers.add("X-Status-Reason", e.message);
        headers.add("X-Status-Error", "Internal Server Error")
        headers.add("X-Status-Exception", e.javaClass.getName())
        headers.add("X-Status-Message", "Token generation failed")

        return ResponseEntity
            .status(status)
            .headers(headers)
            .body( ExceptionMessage(
                    status,
                    "Token submission failed. Please try again with a valid token."
                )
            )
    }

    @ExceptionHandler(InvalidTokenSubmitException::class)
    fun handleInvalidTokenSubmit(e: InvalidTokenSubmitException): ResponseEntity<ExceptionMessage> {

        val status = HttpStatus.UNAUTHORIZED
        val headers = HttpHeaders()

        headers.add("Content-Type", "application/json")
        headers.add("X-Status-Reason", e.message);
        headers.add("X-Status-Error", "Unauthorized")
        headers.add("X-Status-Exception", e.javaClass.getName())
        headers.add("X-Status-Message", "Token submission failed")

        return ResponseEntity
            .status(status)
            .headers(headers)
            .body( ExceptionMessage(
                    status,
                    "Token submission failed. Please try again with a valid token."
                )
            )
    }

}

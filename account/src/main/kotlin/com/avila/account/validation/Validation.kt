package com.avila.account.validation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice class Validation {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleInvalidRequest(e: MethodArgumentNotValidException): ResponseEntity<HashMap<String, String>> {

        val errors: HashMap<String, String> = HashMap()

        e.bindingResult.allErrors
            .forEach { error ->
                errors["validation-error"] = error.defaultMessage ?: "unknown"
            }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errors)

    }

}

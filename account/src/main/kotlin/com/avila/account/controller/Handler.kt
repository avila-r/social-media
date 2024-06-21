package com.avila.account.controller

import com.avila.account.error.Error

import com.github.michaelbull.result.*
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity

interface Handler {

    fun <V, E : Error> handle(result: Result <V, E>) =
        if (result.isErr)
            ResponseEntity.status(result.error.status).body(result.error)
        else
            ResponseEntity.ok(result.value)

    fun <V, E : Error> handle(status: HttpStatus, result: Result<V, E>) =
        if (result.isErr)
            ResponseEntity.status(result.error.status).body(result.error)
        else
            ResponseEntity.status(status).body(result.value)

}

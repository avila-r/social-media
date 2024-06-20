package com.avila.account.controller

import com.avila.account.error.Error

import com.github.michaelbull.result.*

import org.springframework.http.ResponseEntity

interface Handler {

    fun <V, E : Error, R : Result<V, E>> handle(r: R): Result<ResponseEntity<V>, ResponseEntity<E>>  =

        if (r.isErr) Err (
            ResponseEntity.status(r.error.status).body(r.error)
        )

        else Ok (
            ResponseEntity.ok(r.value)
        )

}

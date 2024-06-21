package com.avila.account.controller

import com.avila.account.model.RegisterRequest
import com.avila.account.service.RegistrationService

import jakarta.validation.Valid
import org.springframework.http.HttpStatus

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/auth/register")
@RestController class RegistrationHandler ( private val service: RegistrationService ) : Handler {

    @PostMapping
    fun register(@Valid @RequestBody request: RegisterRequest) = handle(HttpStatus.CREATED, service.register(request))

}

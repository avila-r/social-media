package com.avila.account.controller

import com.avila.account.model.RegisterRequest
import com.avila.account.service.RegistrationService

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/register")
@RestController class RegistrationHandler ( private val service: RegistrationService ) : Handler {

    @PostMapping
    fun register(@RequestBody request: RegisterRequest) = handle(service.register(request))

}

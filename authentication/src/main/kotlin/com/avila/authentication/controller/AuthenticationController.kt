package com.avila.authentication.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/auth")
@RestController class AuthenticationController {

    @GetMapping("/hello")
    fun greeting() = "Hello World"

    @GetMapping("/login")
    fun login() = "Hello World"

    @GetMapping("/register")
    fun register() = "Hello World"

}
package com.avila.authentication.model

import jakarta.validation.constraints.NotBlank

import org.springframework.security.core.Authentication

data class LoginRequest (
    @NotBlank val login: String,
    @NotBlank val password: String
)

data class LoginResponse (
    val token: String,
    val credentials: Authentication
)

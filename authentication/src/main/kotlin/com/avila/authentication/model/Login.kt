package com.avila.authentication.model

import org.springframework.security.core.Authentication

data class LoginRequest (
    val login: String,
    val password: String
)

data class LoginResponse (
    val token: String,
    val credentials: Authentication
)

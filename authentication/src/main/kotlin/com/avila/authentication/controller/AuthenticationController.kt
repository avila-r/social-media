package com.avila.authentication.controller

import com.avila.authentication.exception.InvalidTokenGenerationException
import com.avila.authentication.jwt.service.JsonWebTokenService
import com.avila.authentication.model.Account
import com.avila.authentication.model.LoginRequest
import com.avila.authentication.model.LoginResponse

import jakarta.validation.Valid

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/auth")
@RestController class AuthenticationController ( private val manager: AuthenticationManager, private val service: JsonWebTokenService ) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): LoginResponse {

        val authentication = manager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.login,
                request.password
            )
        )

        return LoginResponse (
            service.generate(authentication.principal as Account) ?: throw InvalidTokenGenerationException("Invalid login submit"), authentication
        )
    }

}

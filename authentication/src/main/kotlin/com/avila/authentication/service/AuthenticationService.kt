package com.avila.authentication.service

import org.springframework.stereotype.Service

import com.avila.authentication.jwt.service.JsonWebTokenService
import com.avila.authentication.model.Account
import com.avila.authentication.model.LoginRequest
import com.avila.authentication.model.LoginResponse

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken as AuthenticationToken

@Service class AuthenticationService (
    private val manager: AuthenticationManager,
    private val jwtService: JsonWebTokenService
) {

    fun login(request: LoginRequest): LoginResponse {

        val authentication = manager.authenticate (
            AuthenticationToken( request.login, request.password )
        )

        return LoginResponse (
            jwtService.generate( authentication.principal as Account ), authentication
        )

    }

}
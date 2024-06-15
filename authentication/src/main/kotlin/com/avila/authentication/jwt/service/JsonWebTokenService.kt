package com.avila.authentication.jwt.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.avila.authentication.model.Account

import java.time.LocalDateTime
import java.time.ZoneOffset

// TODO: Implement logging
@Service class JsonWebTokenService( @Value("\${api.security.jwt.secret}") private val secret: String ) {

    fun generate(user: Account): String? =
        this.runCatching {
            return JWT.create()
                .withIssuer("social-media-platform")
                .withSubject(user.login)
                .withExpiresAt(getExpirationDate())
                .sign(Algorithm.HMAC256("secret-here"))
        }.onFailure {
            return null
        }.getOrNull()

    fun validate(token: String): String? =
        this.runCatching {
            return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("social-media-platform")
                .build()
                .verify(token)
                .subject
        }.onFailure {
            return null
        }.getOrNull()

    private fun getExpirationDate() =
        LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"))

}

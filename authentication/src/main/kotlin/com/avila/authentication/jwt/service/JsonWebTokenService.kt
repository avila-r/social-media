package com.avila.authentication.jwt.service

import com.avila.authentication.model.Account
import org.springframework.stereotype.Service


@Service class JsonWebTokenService {

    fun generate(account: Account) = "oi"

    fun validate(token: String): String = "oi"

}
package com.avila.account.service

import com.avila.account.error.Error
import com.avila.account.model.Account
import com.avila.account.model.Profile
import com.avila.account.model.RegisterRequest
import com.avila.account.model.RegisterResponse

import com.github.michaelbull.result.*

import org.springframework.stereotype.Service

@Service class RegistrationService ( private val accountService: AccountService, private val profileService: ProfileService ) {

    fun register(request: RegisterRequest): Result<RegisterResponse, Error> {

        val pair = request.build()
        val account = accountService.create(pair.first)
        val profile = profileService.create(pair.second)

        if (account.isErr) {
            return Err(account.error)
        }

        if (profile.isErr) {
            return Err(profile.error)
        }

        return Ok(RegisterResponse(account.value, profile.value))

    }

}

private fun RegisterRequest.build() = Pair (
    Account(
        login = this.login,
        password = this.password, // TODO: Encrypt password
        email = this.email
    ),
    Profile(
        fullName = this.fullName,
        birthDate = this.birthDate,
        gender = this.gender
    )
)

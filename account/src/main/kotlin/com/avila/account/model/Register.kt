package com.avila.account.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.Email

import java.time.LocalDate

data class RegisterRequest (
    @field:NotBlank
    val fullName: String,

    @field:Past
    val birthDate: LocalDate,

    @field:Pattern(regexp = "^(?i)(male|female)\$")
    val gender: String,

    @field:NotBlank
    val login: String,

    @NotBlank
    @field:Size(min = 8)
    val password: String,

    @field:Email
    val email: String,
)

data class RegisterResponse (
    val account: Account,
    val profile: Profile
)

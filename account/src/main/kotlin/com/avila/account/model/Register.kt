package com.avila.account.model

import java.time.LocalDate

data class RegisterRequest (
    val fullName: String,
    val birthDate: LocalDate,
    val gender: String,
    val login: String,
    val password: String,
    val email: String,
)

data class RegisterResponse (
    val account: Account,
    val profile: Profile
)

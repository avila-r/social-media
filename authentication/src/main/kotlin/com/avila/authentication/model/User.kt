package com.avila.authentication.model

import jakarta.persistence.*

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Table(name = "accounts")
@Entity class Account (
    val login: String,
    @Column(name = "password_hash") val password: String,
    val email: String,
    val createdAt: LocalDateTime,
    val lastLoginAt: LocalDateTime?,
    val accountStatus: String

) {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id var id: UUID? = null
}

@Table(name = "profiles")
@Entity class Profile (
    val fullName: String,
    val birthDate: LocalDate,
    val gender: String,
    val profilePicture: String,
    val contactInfo: String,
    val preferences: String,
    val privacySettings: String
) {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id var id: UUID? = null
    var accountId: UUID? = null
}

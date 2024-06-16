package com.avila.account.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Table(name = "accounts")
@Entity class Account (

    @Column(name = "login", unique = true, nullable = false)
    val login: String,

    @Column(name = "password_hash", nullable = false)
    val password: String,

    @Column(name = "email", unique = true, nullable = false)
    val email: String,

    ) {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id var id: UUID? = null

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    var createdAt: LocalDateTime? = null

    @Column(name = "status", nullable = false)
    var status: String? = null

    @Column(name = "last_login_at", nullable = true)
    var lastLoginAt: LocalDateTime? = null

}

@Table(name = "profiles")
@Entity class Profile (

    @Column(name = "full_name", nullable = false)
    val fullName: String,

    @Column(name = "birth_date", nullable = false)
    val birthDate: LocalDate,

    @Column(name = "birth_date", nullable = false)
    val gender: String,

    @Column(name = "birth_date", nullable = false)
    val profilePicture: String,

    @Column(name = "birth_date", nullable = false)
    val contactInfo: String, // TODO: Json

    @Column(name = "preferences", nullable = false)
    val preferences: String, // TODO: Json

    @Column(name = "privacy_settings", nullable = false)
    val privacySettings: String
) {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    var id: UUID? = null
    var accountId: UUID? = null
}

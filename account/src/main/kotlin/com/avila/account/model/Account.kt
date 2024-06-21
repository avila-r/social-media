package com.avila.account.model

import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import java.time.LocalDateTime
import java.util.UUID

@Table(name = "accounts")
@EntityListeners(AuditingEntityListener::class)
@Entity class Account (

    @GeneratedValue(strategy = GenerationType.UUID)
    @field:Column(name = "id", unique = true, nullable = false)
    @Id val id: UUID? = null,

    @field:Column(name = "created_at", nullable = false, updatable = false)
    @field:CreatedDate
    val createdAt: LocalDateTime? = null,

    @Column(name = "login", unique = true, nullable = false)
    @field:NotBlank
    val login: String,

    @Column(name = "password_hash", nullable = false)
    @field:Size(min = 8)
    val password: String,

    @Column(name = "email", unique = true, nullable = false)
    @field:Email
    val email: String,

    @field:Column(name = "status", nullable = false)
    val status: String? = null,

    @field:Column(name = "last_login_at", nullable = true)
    val lastLoginAt: LocalDateTime? = null

)

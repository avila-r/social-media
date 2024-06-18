package com.avila.account.model

import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

import org.springframework.data.annotation.CreatedDate

import java.time.LocalDateTime
import java.util.UUID

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
    @Column(name = "id", unique = true, nullable = false)
    @Id var id: UUID? = null

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    var createdAt: LocalDateTime? = null

    @Column(name = "status", nullable = false)
    var status: String? = null

    @Column(name = "last_login_at", nullable = true)
    var lastLoginAt: LocalDateTime? = null

}

package com.avila.authentication.model

import jakarta.persistence.*

import org.springframework.data.annotation.CreatedDate
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

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

) : UserDetails {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id var id: UUID? = null

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    var createdAt: LocalDateTime? = null

    @Column(name = "status", nullable = false)
    var accountStatus: String? = null

    @Column(name = "last_login_at", nullable = true)
    var lastLoginAt: LocalDateTime? = null

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

}

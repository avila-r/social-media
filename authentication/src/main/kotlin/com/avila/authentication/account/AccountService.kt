package com.avila.authentication.account

import com.avila.authentication.repository.AccountRepository

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service class AccountService ( private val repository: AccountRepository ) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? =
        runCatching {
            return repository.findByLogin(username)
        }.onFailure {
            return null
        }.getOrNull()
}

package com.avila.account.service

import com.avila.account.model.Account
import com.avila.account.repository.AccountRepository

import org.springframework.stereotype.Service

@Service class AccountService ( private val repository: AccountRepository ) {

    fun create(): Account? {
        return null
    }

    fun update(): Account? {
        return null
    }

    fun delete(): Boolean {
        return false
    }

    fun getById(): Account? {
        return null
    }

    fun getByLogin(): Account? {
        return null
    }

    fun getByEmail(): Account? {
        return null
    }

}
package com.avila.account.service

import com.github.michaelbull.result.*

import com.avila.account.error.AccountError
import com.avila.account.error.Error as Err
import com.avila.account.model.Account
import com.avila.account.repository.AccountRepository
import com.avila.account.repository.validate

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.UUID

@Service class AccountService ( private val repository: AccountRepository ) {

    @Transactional fun create(account: Account): Result<Account, Err> {

        val validation = repository.validate(account)

        if (validation.isErr) {
            return Err(validation.error)
        }

        return Ok(repository.save(account))

    }

    @Transactional fun update(account: Account): Result<Account, Err> {

        if (!repository.existsById(account.id)) {
            return Err(AccountError.ACCOUNT_NOT_FOUND)
        }

        return Ok(repository.save(account))

    }

    @Transactional fun deleteById(id: UUID?): Result<Boolean, Err> {

        val account = repository.findById(id) ?: return Err(AccountError.ACCOUNT_NOT_FOUND)

        repository.delete(account)

        return Ok(true)

    }

    fun getById(id: UUID?): Result<Account, Err> {

        val account = repository.findById(id) ?: return Err(AccountError.ACCOUNT_NOT_FOUND)

        return Ok(account)

    }

    fun getByLogin(login: String?): Result<Account, Err> {

        val account = repository.findByLogin(login) ?: return Err(AccountError.ACCOUNT_NOT_FOUND)

        return Ok(account)

    }

    fun getByEmail(email: String?): Result<Account, AccountError> {

        val account = repository.findByEmail(email) ?: return Err(AccountError.ACCOUNT_NOT_FOUND)

        return Ok(account)

    }

}

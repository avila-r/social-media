package com.avila.authentication.repository

import com.avila.authentication.model.Account

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.util.UUID

@Repository interface AccountRepository : CrudRepository<Account, UUID> {
    fun findByLogin(login: String?): Account?
}
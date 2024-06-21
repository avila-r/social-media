package com.avila.account.repository

import com.avila.account.model.Account

import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository

import java.time.LocalDateTime
import java.util.UUID

@Repository
interface AccountRepository : ListCrudRepository<Account, UUID> {

    fun findById(uuid: UUID?): Account?

    fun findByLogin(login: String?): Account?

    fun findByEmail(email: String?): Account?

    fun findAllByCreatedAtAfter(createdAt: LocalDateTime?): List<Account>?

    fun findAllByStatus(status: String?): List<Account>?

    fun findAllByLastLoginAtAfter(lastLoginAt: LocalDateTime?): List<Account>?

    fun existsByEmail(email: String?): Boolean

    fun existsByLogin(login: String?): Boolean

    fun existsById(id: UUID?): Boolean

}

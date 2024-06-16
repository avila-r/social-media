package com.avila.account.repository

import com.avila.account.model.Account
import com.avila.account.model.Profile

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.util.UUID

@Repository interface AccountRepository : CrudRepository<Account, UUID> {

    fun findByLogin()

    fun findByEmail()

    fun findAllByCreatedAtAfter()

    fun findAllByStatus()

    fun findAllByLastLoginAtAfter()

}

@Repository interface ProfileRepository : CrudRepository<Profile, UUID> {

    fun findAllByFullName()

    fun findAllByBirthDate()

    fun findAllByGender()

}

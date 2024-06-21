package com.avila.account.repository

import com.avila.account.model.Profile

import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository

import java.time.LocalDate
import java.util.UUID

@Repository interface ProfileRepository : ListCrudRepository<Profile, UUID> {

    fun findById(uuid: UUID?): Profile?

    fun findAllByFullName(fullName: String?): List<Profile>?

    fun findAllByBirthDate(birthday: LocalDate?): List<Profile>?

    fun findAllByGender(gender: String?): List<Profile>?

    fun existsById(uuid: UUID?): Boolean

    fun existsByAccountId(uuid: UUID?): Boolean

}

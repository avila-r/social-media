package com.avila.account.service

import com.github.michaelbull.result.*

import com.avila.account.error.Error as Err
import com.avila.account.error.ProfileError
import com.avila.account.model.Profile
import com.avila.account.repository.ProfileRepository
import com.avila.account.repository.validate

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.UUID

@Service
class ProfileService ( private val repository: ProfileRepository ) {

    @Transactional fun create(profile: Profile): Result<Profile, Err> {

        val validation = repository.validate(profile)

        if (validation.isErr) {
            return Err(validation.error)
        }

        return Ok(repository.save(profile))

    }

    @Transactional fun update(profile: Profile): Result<Profile, Err> {

        if (!repository.existsById(profile.id)) {
            return Err(ProfileError.PROFILE_NOT_FOUND)
        }

        return Ok(repository.save(profile))

    }

    @Transactional fun deleteById(uuid: UUID?): Result<Boolean, Err> {

        val profile = repository.findById(uuid) ?: return Err(ProfileError.PROFILE_NOT_FOUND)

        repository.delete(profile)

        return Ok(true)

    }

    fun getById(uuid: UUID?): Result<Profile, Err> {

        val profile = repository.findById(uuid) ?: return Err(ProfileError.PROFILE_NOT_FOUND)

        return Ok(profile)

    }

    fun getByAccountId(uuid: UUID?): Result<Profile, Err> {

        val profile = repository.findById(uuid) ?: return Err(ProfileError.PROFILE_NOT_FOUND)

        return Ok(profile)

    }

}

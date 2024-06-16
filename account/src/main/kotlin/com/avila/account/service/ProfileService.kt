package com.avila.account.service

import com.avila.account.model.Profile
import com.avila.account.repository.ProfileRepository

import org.springframework.stereotype.Service

@Service
class ProfileService (private val repository: ProfileRepository ) {

    fun create(): Profile? {
        return null
    }

    fun update(): Profile? {
        return null
    }

    fun delete(): Boolean {
        return false
    }

    fun getById(): Profile? {
        return null
    }

    fun getByAccountId(): Profile? {
        return null
    }

}

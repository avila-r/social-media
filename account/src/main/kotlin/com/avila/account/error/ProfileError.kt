package com.avila.account.error

import org.springframework.http.HttpStatus

/**
 * Enum representing profile-related errors that can occur in the system.
 */
enum class ProfileError : Error {

    /**
     * Error indicating that a profile is already registered to an account.
     */
    PROFILE_ALREADY_REGISTERED_AT_ACCOUNT {
        override val status = HttpStatus.CONFLICT
        override val message = "account already has a profile"
    },

    /**
     * Error indicating that a requested profile was not found.
     */
    PROFILE_NOT_FOUND {
        override val status = HttpStatus.NOT_FOUND
        override val message = "profile not found"
    };

    override fun toString() = message

}

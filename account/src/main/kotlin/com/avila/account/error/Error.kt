package com.avila.account.error

/**
 * Interface defining the structure for API errors.
 */
interface Error {
    val message: String  // Message describing the error
}

/**
 * Extension function to retrieve the message from any implementation of [Error].
 * @return The error message.
 */
fun Error.message(): String {
    return this.message
}

/**
 * Enum representing profile-related errors that can occur in the system.
 */
enum class ProfileError : Error {

    /**
     * Error indicating that a profile is already registered to an account.
     */
    PROFILE_ALREADY_REGISTERED_AT_ACCOUNT {
        override val message = "account already has a profile"
    },

    /**
     * Error indicating that a requested profile was not found.
     */
    PROFILE_NOT_FOUND {
        override val message = "profile not found"
    };

    override fun toString() = message
}

/**
 * Enum representing account-related errors that can occur in the system.
 */
enum class AccountError : Error {

    /**
     * Error indicating that a requested account was not found.
     */
    ACCOUNT_NOT_FOUND {
        override val message = "account not found"
    },

    /**
     * Error indicating that an email address is already in use.
     */
    EMAIL_ALREADY_IN_USE {
        override val message = "e-mail already in use"
    },

    /**
     * Error indicating that a username is already in use.
     */
    USERNAME_ALREADY_IN_USE {
        override val message = "username already in use"
    },

    /**
     * Error indicating that an email address has an invalid format.
     */
    INVALID_EMAIL {
        override val message = "invalid e-mail format"
    },

    /**
     * Error indicating that a request for an account is invalid.
     */
    INVALID_ACCOUNT_REQUEST {
        override val message = "invalid account request"
    };

    override fun toString() = message
}

package com.avila.account.error

import org.springframework.http.HttpStatus

/**
 * Enum representing account-related errors that can occur in the system.
 */
enum class AccountError : Error {

    /**
     * Error indicating that a requested account was not found.
     */
    ACCOUNT_NOT_FOUND {
        override val status = HttpStatus.NOT_FOUND
        override val message = "account not found"
    },

    /**
     * Error indicating that an email address is already in use.
     */
    EMAIL_ALREADY_IN_USE {
        override val status = HttpStatus.CONFLICT
        override val message = "e-mail already in use"
    },

    /**
     * Error indicating that a username is already in use.
     */
    USERNAME_ALREADY_IN_USE {
        override val status = HttpStatus.CONFLICT
        override val message = "username already in use"
    },

    /**
     * Error indicating that an email address has an invalid format.
     */
    INVALID_EMAIL {
        override val status = HttpStatus.BAD_REQUEST
        override val message = "invalid e-mail format"
    },

    /**
     * Error indicating that a request for an account is invalid.
     */
    INVALID_ACCOUNT_REQUEST {
        override val status = HttpStatus.UNPROCESSABLE_ENTITY
        override val message = "invalid account request"
    };

    override fun toString() = message

}

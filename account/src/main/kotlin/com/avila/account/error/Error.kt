package com.avila.account.error

import org.springframework.http.HttpStatus

/**
 * Interface defining the structure for API errors.
 */
interface Error {
    val status: HttpStatus
    val message: String  // Message describing the error
}

/**
 * Extension function to retrieve the message from any implementation of [Error].
 * @return The error message.
 */
fun Error.message(): String {
    return this.message
}

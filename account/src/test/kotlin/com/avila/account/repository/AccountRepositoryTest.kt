package com.avila.account.repository

import com.avila.account.model.Account

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.context.ActiveProfiles

import java.time.LocalDateTime

@ActiveProfiles("test")
@DataJpaTest class AccountRepositoryTest ( @Autowired private val repository: AccountRepository ) {

    @Test fun `asserts that can save account with non-null values`() {

        val account = this.repository.save(
            Account (
                login = "test-login",
                password = "test-password",
                email = "email@test.com",
                status = "created",
                createdAt = LocalDateTime.now()
            )
        )

        assertThat(account.createdAt).isNotNull()
        assertThat(account.lastLoginAt).isNull()
        assertThat(account.id).isNotNull()

    }

    @Test fun `asserts that password is encoded`() {

        val encoder = BCryptPasswordEncoder()

        val account = this.repository.save(
            Account (
                login = "test-login",
                password = encoder.encode("test-password"),
                email = "email@test.com",
                status = "created",
                createdAt = LocalDateTime.now()
            )
        )

        assertThat(encoder.matches("test-password", account.password)).isTrue()
        assertThat(account.password).isNotEqualTo("test-password")

    }

}

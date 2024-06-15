package com.avila.authentication.repository

import com.avila.authentication.model.Account

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

import java.time.LocalDateTime

@ActiveProfiles("test")
@DataJpaTest class AccountRepositoryTest (@Autowired private var repository: AccountRepository) {

    @Test fun `asserts that can save account with non-null uuid`() {

        val account = this.repository.save(
            Account (
                login = "test-login",
                password = "test-password",
                email = "email@test.com",
                createdAt = LocalDateTime.now(),
                lastLoginAt = null,
                accountStatus = "created"
            )
        )

        assertThat(account.id).isNotNull()

    }

}

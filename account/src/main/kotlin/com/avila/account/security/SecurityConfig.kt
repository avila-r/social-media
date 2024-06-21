package com.avila.account.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration class SecurityConfig {

    @Bean fun publishSecurityFilterChain(http: HttpSecurity): SecurityFilterChain = http

        .csrf {
            it.disable()
        }

        .cors {
            it.disable()
        }

        .sessionManagement {
            it.sessionCreationPolicy (
                SessionCreationPolicy.STATELESS
            )
        }

        .authorizeHttpRequests {
            it.anyRequest().permitAll()
        }

        .build()

    @Bean fun publishEncoder() = BCryptPasswordEncoder()

}

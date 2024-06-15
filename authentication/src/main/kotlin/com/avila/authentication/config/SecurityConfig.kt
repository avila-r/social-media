package com.avila.authentication.config

import com.avila.authentication.jwt.filter.JsonWebTokenFilter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

import org.springframework.security.config.annotation.web.builders.HttpSecurity as Http
import org.springframework.security.config.http.SessionCreationPolicy as Session
import org.springframework.security.web.SecurityFilterChain as Filter

import jakarta.servlet.http.HttpServletResponse as Response

@EnableWebSecurity
@Configuration class SecurityFilterConfig (private val jwt: JsonWebTokenFilter) {

    @Bean fun publishSecurityFilterChain( http: Http ): Filter = http

        .csrf {
            it.disable()
        }

        .cors {
            it.disable()
        }

        .sessionManagement {
            it.sessionCreationPolicy( Session.STATELESS )
        }

        .authorizeHttpRequests { it
            .requestMatchers("/api/v1/auth/**").permitAll()
            .requestMatchers("/api/v1/public/**").permitAll()
            .anyRequest().authenticated()
        }

        .addFilterBefore( jwt, UsernamePasswordAuthenticationFilter::class.java )

        .exceptionHandling { it
            .authenticationEntryPoint {
                _, response, e -> response.sendError( Response.SC_UNAUTHORIZED, e.message )
            }
        }

        .build()

}

@Configuration class AuthenticationConfig {

    @Bean fun publishManager(config: AuthenticationConfiguration): AuthenticationManager = config.authenticationManager

    @Bean fun publishEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}

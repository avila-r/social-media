package com.avila.authentication.jwt.filter

import org.springframework.stereotype.Component

import com.avila.authentication.jwt.service.JsonWebTokenService
import com.avila.authentication.account.AccountService

import org.springframework.web.filter.OncePerRequestFilter

import jakarta.servlet.http.HttpServletRequest as Request
import jakarta.servlet.http.HttpServletResponse as Response
import jakarta.servlet.FilterChain as Chain

import org.springframework.http.HttpHeaders as Header

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken as AuthenticationToken

@Component class JsonWebTokenFilter (
    private val tokenService: JsonWebTokenService,
    private val accountService: AccountService
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: Request, response: Response, chain: Chain) {
        val token: String? = getAuthorizationHeader(request)

        token?.let {
            val account = accountService.loadUserByUsername(tokenService.validate(token))

            account?.let {
                SecurityContextHolder.getContext().authentication =
                    AuthenticationToken ( account, null, account.authorities )
            }
        }

        chain.doFilter(request, response)
    }

    private fun getAuthorizationHeader(request: Request): String? {
        val token: String? = request.getHeader(Header.AUTHORIZATION)

        return token?.let {
            if (token.startsWith("Bearer ")) token.replace("Bearer ", "") else null
        }
    }

}

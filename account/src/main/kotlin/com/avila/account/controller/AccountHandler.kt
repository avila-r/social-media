package com.avila.account.controller

import com.avila.account.model.Account
import com.avila.account.service.AccountService

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.UUID

@RequestMapping("/api/v1/account")
@RestController class AccountHandler ( private val service: AccountService ) : Handler {

    @PatchMapping
    fun updateAccount(@RequestBody account: Account) = handle(service.update(account))

    @DeleteMapping("/id/{id}")
    fun deleteAccount(@PathVariable id: String?) = handle(service.deleteById(id?.let { UUID.fromString(it) }))

    @GetMapping("/id/{id}")
    fun getAccountById(@PathVariable id: String?) = handle(service.getById(id?.let { UUID.fromString(it) }))

    @GetMapping("/login/{login}")
    fun getAccountByLogin(@PathVariable login: String?) = handle(service.getByLogin(login))

    @GetMapping("/email/{email}")
    fun getAccountByEmail(@PathVariable email: String?) = handle(service.getByEmail(email))

}

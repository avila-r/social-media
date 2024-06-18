package com.avila.account.controller

import com.avila.account.model.Profile
import com.avila.account.service.ProfileService

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.UUID

@RequestMapping("/api/v1/profile")
@RestController class ProfileHandler ( private val service: ProfileService ) : Handler {

    @PatchMapping
    fun updateProfile(profile: Profile) = handle(service.update(profile))

    @DeleteMapping("/id/{id}")
    fun deleteProfile(@PathVariable id: String?) = handle(service.deleteById(id?.let { UUID.fromString(it) }))

    @GetMapping("/id/{id}")
    fun getProfileById(@PathVariable id: String?) = handle(service.getById(id?.let { UUID.fromString(it) }))

    @GetMapping("/account/{id}")
    fun getProfileByAccountId(@PathVariable id: String?) = handle(service.getByAccountId(id?.let { UUID.fromString(it) }))

}
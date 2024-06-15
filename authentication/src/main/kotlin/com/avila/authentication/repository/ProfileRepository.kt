package com.avila.authentication.repository

import com.avila.authentication.model.Profile

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.util.UUID

@Repository interface ProfileRepository : CrudRepository<Profile, UUID>
package com.avila.account.model

import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern

import java.time.LocalDate
import java.util.UUID

@Table(name = "profiles")
@Entity class Profile (

    @Column(name = "full_name", nullable = false)
    @field:NotBlank
    val fullName: String,

    @Column(name = "birth_date", nullable = false)
    @field:Past
    val birthDate: LocalDate,

    @Column(name = "gender", nullable = false)
    @field:Pattern(regexp = "^(?i)(male|female)\$")
    val gender: String,

    ) {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    @Id var id: UUID? = null

    @Column(name = "account_id", nullable = false)
    var accountId: UUID? = null

    @Column(name = "profile_picture", nullable = true)
    var profilePicture: String? = null

    @Column(name = "contact_info", nullable = true)
    var contactInfo: String? = null // TODO: Json

    @Column(name = "preferences", nullable = true)
    var preferences: String? = null // TODO: Json

    @Column(name = "privacy_settings", nullable = true)
    var privacySettings: String? = null // Todo: Json

}

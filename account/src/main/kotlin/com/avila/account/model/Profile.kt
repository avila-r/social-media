package com.avila.account.model

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Table(name = "profiles")
@Entity class Profile (

    @Column(name = "full_name", nullable = false)
    val fullName: String,

    @Column(name = "birth_date", nullable = false)
    val birthDate: LocalDate,

    @Column(name = "gender", nullable = false)
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

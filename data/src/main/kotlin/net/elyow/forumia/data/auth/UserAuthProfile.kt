package net.elyow.forumia.data.auth

import kotlinx.serialization.Serializable

/**
 * User auth profile
 *
 * @property uid
 * @property salt
 * @property password
 * @property _uid database internal representation of the user, **NOT** the profile.
 */
@Serializable
data class UserAuthProfile(
    val uid: String,
    val salt: String,
    val password: String,
    val _uid: String? = null,
)
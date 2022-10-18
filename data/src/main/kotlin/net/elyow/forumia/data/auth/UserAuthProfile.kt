package net.elyow.forumia.data.auth

import kotlinx.serialization.Serializable

/**
 * User Auth Profile
 * @property username User's identity.
 * @property salt BCrypt salt for the password.
 * @property password Password it self.
 */

@Serializable
data class UserAuthProfile(
    val username: String,
    val salt: String,
    val password: String,
)
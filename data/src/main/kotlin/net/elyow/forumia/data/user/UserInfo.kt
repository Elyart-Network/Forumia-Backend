package net.elyow.forumia.data.user

import kotlinx.serialization.Serializable

/**
 * UserInfo User's Profile
 * @property uid MYSQL PRIMARY KEY (auto) user's identity.
 * @property username User's identity.
 * @property email User's identity.
 * @property nickname User's custom name.
 * @property avatar Http link to user's profile pic.
 * @property verified If user has been verified.
 */

@Serializable
data class UserInfo(
    val uid: String,
    val username: String,
    val email: String,
    val nickname: String,
    val avatar: String?,
    val verified: Boolean,
)
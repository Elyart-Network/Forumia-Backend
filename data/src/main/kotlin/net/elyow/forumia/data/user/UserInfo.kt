package net.elyow.forumia.data.user

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val uid: String,
    val username: String,
    val email: String,
    val verified: String,
    val _id: String? = null
)
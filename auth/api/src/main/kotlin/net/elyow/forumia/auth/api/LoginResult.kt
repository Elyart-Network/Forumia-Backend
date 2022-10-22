package net.elyow.forumia.auth.api

sealed interface LoginResult {
    class Success(val token: String) : LoginResult

    class Failed(val reason: String? = null) : LoginResult
}
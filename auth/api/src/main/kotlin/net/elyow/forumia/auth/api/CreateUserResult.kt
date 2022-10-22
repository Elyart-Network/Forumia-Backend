package net.elyow.forumia.auth.api

sealed interface CreateUserResult {
    object Success : CreateUserResult
    data class Failed(val msg: String) : CreateUserResult
}
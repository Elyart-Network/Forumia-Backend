package net.elyow.forumia.auth.api

fun interface EmailValidation {
    suspend fun validate(email: String): Boolean
}


fun interface PasswordValidation {
    suspend fun validate(password: String): Boolean
}
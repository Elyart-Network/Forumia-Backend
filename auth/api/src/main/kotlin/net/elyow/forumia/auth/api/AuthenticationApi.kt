package net.elyow.forumia.auth.api

import kotlinx.coroutines.CoroutineScope
import net.elyow.forumia.data.user.UserInfo

interface AuthenticationApi {


    suspend fun createUser(email: String, password: String): CreateUserResult

    suspend fun loginWithEmail(email: String, password: String): LoginResult


    /**
     * Verify token
     *
     * @param token
     * @return null if invalid token
     */
    suspend fun verifyToken(token: String): UserInfo?

}
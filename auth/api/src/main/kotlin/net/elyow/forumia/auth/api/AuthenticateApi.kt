package net.elyow.forumia.auth.api

import net.elyow.forumia.data.user.UserInfo

interface AuthenticateApi {


    fun verifyToken(token: String): UserInfo

}
package net.elyow.forumia.auth.impl.firebase

import com.google.api.core.ApiFutureCallback
import com.google.api.core.ApiFutures
import com.google.common.util.concurrent.MoreExecutors
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseToken
import com.google.firebase.auth.UserRecord
import net.elyow.forumia.auth.api.AuthenticationApi
import net.elyow.forumia.auth.api.CreateUserResult
import net.elyow.forumia.auth.api.LoginResult
import net.elyow.forumia.data.user.UserInfo
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseAuthentication(private val auth: FirebaseAuth) : AuthenticationApi {

    override suspend fun createUser(email: String, password: String) = suspendCoroutine { cont ->

        val request = UserRecord.CreateRequest()
            .setEmail(email)
            .setPassword(password)

        val future = auth.createUserAsync(request)


        ApiFutures.addCallback(
            future,
            object : ApiFutureCallback<UserRecord> {
                override fun onFailure(t: Throwable) {
                    when (t) {
                        is FirebaseAuthException -> cont.resume(CreateUserResult.Failed(t.errorCode.toString() + t.message))
                        else -> cont.resumeWithException(t)
                    }
                }

                override fun onSuccess(result: UserRecord) {
                    cont.resume(CreateUserResult.Success)
                }

            },
            MoreExecutors.directExecutor() // TODO: google java code drama
        )
    }


    override suspend fun loginWithEmail(email: String, password: String): LoginResult {
        error("Firebase login is on front end")
    }

    override suspend fun verifyToken(token: String): UserInfo? = suspendCoroutine { cont ->
        ApiFutures.addCallback(
            auth.verifyIdTokenAsync(token),
            object : ApiFutureCallback<FirebaseToken> {
                override fun onFailure(t: Throwable) {
                    when (t) {
                        is FirebaseAuthException -> cont.resume(null)
                        else -> cont.resumeWithException(t)
                    }
                }

                override fun onSuccess(result: FirebaseToken) {
                    val userInfo = UserInfo(
                        uid = result.uid,
                        username = result.name,
                        email = result.email,
                        nickname = result.name, // do it for now
                        avatar = result.picture,
                        verified = result.isEmailVerified
                    )
                    cont.resume(userInfo)
                }
            },
            MoreExecutors.directExecutor() // TODO: google java code drama
        )
    }


}
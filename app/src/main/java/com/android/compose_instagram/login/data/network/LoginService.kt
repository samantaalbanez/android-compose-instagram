package com.android.compose_instagram.login.data.network

import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}

package com.android.compose_instagram.login.data

import com.android.compose_instagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {

    suspend fun doLogin(email: String, password: String): Boolean =
        api.doLogin(email = email, password = password)
}

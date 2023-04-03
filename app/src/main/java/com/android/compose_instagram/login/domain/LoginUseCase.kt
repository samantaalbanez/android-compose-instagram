package com.android.compose_instagram.login.domain

import com.android.compose_instagram.login.data.LoginRepository

class LoginUseCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(email: String, password: String): Boolean =
        repository.doLogin(email = email, password = password)
}

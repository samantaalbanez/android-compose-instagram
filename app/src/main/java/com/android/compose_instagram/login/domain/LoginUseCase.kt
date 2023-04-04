package com.android.compose_instagram.login.domain

import com.android.compose_instagram.login.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    suspend operator fun invoke(email: String, password: String): Boolean =
        loginRepository.doLogin(email = email, password = password)
}

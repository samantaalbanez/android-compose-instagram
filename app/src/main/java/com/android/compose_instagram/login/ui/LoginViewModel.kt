package com.android.compose_instagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = enabledLogin()
    }

    private fun enabledLogin(): Boolean =
        (Patterns.EMAIL_ADDRESS.matcher(email.value.orEmpty()).matches() && password.value.orEmpty().length >= 6)
}

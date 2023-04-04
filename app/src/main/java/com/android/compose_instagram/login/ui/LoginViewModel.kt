package com.android.compose_instagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.compose_instagram.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = enabledLogin()
    }

    private fun enabledLogin(): Boolean =
        (Patterns.EMAIL_ADDRESS.matcher(email.value.orEmpty()).matches() && password.value.orEmpty().length >= 6)

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email = email.value.orEmpty(), password = password.value.orEmpty())
            if (result) {
                //navegar
                Log.i("Login", "Navegar ate a seguinte tela")
            }
            _isLoading.value = false
        }
    }
}

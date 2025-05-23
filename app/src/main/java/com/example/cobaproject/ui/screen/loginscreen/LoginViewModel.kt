package com.example.cobaproject.ui.screen.loginscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cobaproject.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

    class LoginViewModel(private val repository: UserRepository) : ViewModel() {
        private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
        val loginState: StateFlow<LoginState> = _loginState

        fun login(nim: String, password: String) {
            viewModelScope.launch {
                _loginState.value = LoginState.Loading
//                try {
//                    val response = repository.login(nim, password)
//                    if (response.isSuccessful) {
//                        val body = response.body()
//                        println("Response body: $body") // untuk debugging
//                    } else {
//                        _loginState.value = LoginState.Error("Login gagal: ${response.code()}")
//                    }
//                } catch (e: Exception) {
//                    _loginState.value = LoginState.Error("Terjadi kesalahan: ${e.message}")
//                }
            }
        }
    }

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val message: String) : LoginState()
    data class Error(val error: String) : LoginState()
}
package com.example.cobaproject.ui.screen.LoginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cobaproject.data.repository.AuthRepository

class LoginViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = AuthRepository() // pastikan ini tidak null
        return LoginViewModel(repository) as T
    }
}

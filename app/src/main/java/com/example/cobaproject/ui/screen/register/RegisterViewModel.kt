package com.example.cobaproject.ui.screen.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cobaproject.domain.usecase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    fun register(name: String, email: String, password: String){
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            try {
                val user = registerUserUseCase(name,email,password)
                state = state.copy(isLoading = false, succes = true, user = user)
            } catch (e: Exception){
                state = state.copy(isLoading = false, error = e.message)
            }
        }
    }
}
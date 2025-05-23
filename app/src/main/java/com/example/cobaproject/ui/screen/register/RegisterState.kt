package com.example.cobaproject.ui.screen.register

import com.example.cobaproject.domain.model.User

data class RegisterState(
    val isLoading: Boolean = false,
    val succes: Boolean = false,
    val error: String? = null,
    val user: User? = null
)

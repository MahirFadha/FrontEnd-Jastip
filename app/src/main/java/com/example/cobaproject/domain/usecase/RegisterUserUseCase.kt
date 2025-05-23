package com.example.cobaproject.domain.usecase

import com.example.cobaproject.domain.model.User
import com.example.cobaproject.domain.repository.UserRepository

class RegisterUserUseCase(private val repo: UserRepository) {
    suspend operator fun invoke(name: String,email: String, password: String): User{
        return repo.registerUser(name,email,password)
    }
}
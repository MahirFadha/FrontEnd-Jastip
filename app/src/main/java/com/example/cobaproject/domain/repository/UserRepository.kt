package com.example.cobaproject.domain.repository

import com.example.cobaproject.domain.model.User

interface UserRepository {
    suspend fun registerUser(name:String,email:String,password:String): User
}
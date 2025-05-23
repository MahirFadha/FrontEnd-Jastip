package com.example.cobaproject.data.repository

import com.example.cobaproject.data.local.UserDao
import com.example.cobaproject.data.mapper.toEntity
import com.example.cobaproject.data.remote.ApiService
import com.example.cobaproject.data.remote.RegisterRequest
import com.example.cobaproject.domain.model.User
import com.example.cobaproject.domain.repository.UserRepository

class UserRepositoryImpl (
    private val api: ApiService,
    private val dao: UserDao
) : UserRepository {

    override suspend fun registerUser(name: String, email:String, password: String): User{
        val request = RegisterRequest(name,email,password)
        val response = api.registerUser(request)
        val user = User(response.id, response.name, response.nim)
        dao.insertUser(user.toEntity())
        return user
    }
}
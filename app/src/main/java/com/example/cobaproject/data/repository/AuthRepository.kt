package com.example.cobaproject.data.repository

import com.example.cobaproject.data.model.LoginRequest
import com.example.cobaproject.data.model.LoginResponse
import com.example.cobaproject.data.remote.RetrofitClient
import retrofit2.Response

class AuthRepository {
    suspend fun login(nim: String, password: String): Response<LoginResponse> {
        return RetrofitClient.instance.login(LoginRequest(nim,password))
    }
}
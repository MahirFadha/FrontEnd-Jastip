package com.example.cobaproject.data.remote

import com.example.cobaproject.data.model.LoginRequest
import com.example.cobaproject.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
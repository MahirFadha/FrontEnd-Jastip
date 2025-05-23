package com.example.cobaproject.data.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): RegisterResponseDto
}
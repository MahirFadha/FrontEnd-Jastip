package com.example.cobaproject.data.mapper

import com.example.cobaproject.data.local.UserEntity
import com.example.cobaproject.domain.model.User

fun UserEntity.toDomain() = User(id,name,nim)
fun User.toEntity() = UserEntity(id,name,nim)
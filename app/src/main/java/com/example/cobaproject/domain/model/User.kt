package com.example.cobaproject.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val nim: Long
)

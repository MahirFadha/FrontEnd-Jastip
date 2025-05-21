package com.example.cobaproject.dataLokal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class Users(
    @PrimaryKey val idUser: Int,
    @ColumnInfo val nim: Long,
    @ColumnInfo val nama: String,
    @ColumnInfo val username: String
)

package com.example.cobaproject.dataLokal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cobaproject.dataLokal.dao.UsersDao
import com.example.cobaproject.dataLokal.entity.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase(){
    abstract fun userDao(): UsersDao
}
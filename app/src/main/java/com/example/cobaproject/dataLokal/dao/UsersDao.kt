package com.example.cobaproject.dataLokal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cobaproject.dataLokal.entity.Users

@Dao
interface UsersDao {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(users: Users)

   @Update
   suspend fun update(users: Users)

   @Delete
   suspend fun delete(users: Users)

   @Query("SELECT * FROM user ORDER BY nama ASC")
   suspend fun getAllUser(): List<Users>
}
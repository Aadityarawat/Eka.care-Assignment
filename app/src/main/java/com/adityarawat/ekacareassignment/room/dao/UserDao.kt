package com.adityarawat.ekacareassignment.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.adityarawat.ekacareassignment.room.entities.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("Select * from user")
    fun getUser() : LiveData<List<User>>
}
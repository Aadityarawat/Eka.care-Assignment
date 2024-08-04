package com.adityarawat.ekacareassignment.repository

import androidx.lifecycle.LiveData
import com.adityarawat.ekacareassignment.room.database.UserDatabase
import com.adityarawat.ekacareassignment.room.entities.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDatabase: UserDatabase) {


    fun getUser() : LiveData<List<User>>{
        return userDatabase.userDao().getUser()
    }

    suspend fun insertUser(user: User){
        userDatabase.userDao().insertUser(user)
    }
}
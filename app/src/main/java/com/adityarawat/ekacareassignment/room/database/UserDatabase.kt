package com.adityarawat.ekacareassignment.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adityarawat.ekacareassignment.room.dao.UserDao
import com.adityarawat.ekacareassignment.room.entities.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao
}
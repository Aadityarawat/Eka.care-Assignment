package com.adityarawat.ekacareassignment.room.dao

import android.content.Context
import androidx.room.Room
import com.adityarawat.ekacareassignment.room.database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserDaoModule {

    @Singleton
    @Provides
    fun providesUserDatabase(@ApplicationContext context : Context) : UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, "user_database").build()
    }
}
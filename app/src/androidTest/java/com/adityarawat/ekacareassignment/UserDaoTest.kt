package com.adityarawat.ekacareassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.adityarawat.ekacareassignment.room.dao.UserDao
import com.adityarawat.ekacareassignment.room.database.UserDatabase
import com.adityarawat.ekacareassignment.room.entities.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserDaoTest {

    @get: Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var userDatabase: UserDatabase
    lateinit var userDao: UserDao

    @Before
    fun setUp(){
        userDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = userDatabase.userDao()
    }

    @Test
    fun insertUser_expectedSingleUser() = runBlocking{
        val user = User(0,"Aditya","23","10/Aug/2001","Chandigarh")
        userDao.insertUser(user)

        val result = userDao.getUser().getOrAwaitValue()

        Assert.assertEquals(1, result.size)
        Assert.assertEquals("Aditya", result[0].name)
    }

    @After
    fun tearDown(){
        userDatabase.close()
    }
}
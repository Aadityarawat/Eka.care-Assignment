package com.adityarawat.ekacareassignment.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val age : String,
    val date : String,
    val address : String
)
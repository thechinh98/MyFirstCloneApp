package com.example.myfirstcloneapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor


@Entity(indices = arrayOf(Index(value = ["username"],unique = true)))
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) var id : Int,
    @ColumnInfo(name = "username") var username : String,
    @ColumnInfo(name = "password") var password : String


)
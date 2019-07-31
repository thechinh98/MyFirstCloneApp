package com.example.myfirstcloneapp

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM todoentity")

    fun getAll(): List<TodoEntity>
    @Query("SELECT * FROM todoentity where username LIKE :username")
    fun findByUsername(username : String) : TodoEntity

    @Insert
    fun  insertAll(vararg todos: TodoEntity)

    @Delete
    fun  delete(todo: TodoEntity)

    @Update
    fun update(vararg todos: TodoEntity)

    @Query("SELECT password from todoentity where username LIKE :username")
    fun findPassByUsername(username: String) : String


}
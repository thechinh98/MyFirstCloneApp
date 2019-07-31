package com.example.myfirstcloneapp

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_registration.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter


class ActivityRegistration : AppCompatActivity() {
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,"user-list.db"
        ).build()

        btn_confirm.setOnClickListener {
            editText = findViewById(R.id.RegisUser) as EditText
            var username = editText.text.toString()
            editText = findViewById(R.id.RegisPass) as EditText
            var pass = editText.text.toString()
            editText = findViewById(R.id.RepeatPass) as EditText
            var tempPass = editText.text.toString()

            if (pass.equals(tempPass)) {
                db.todoDao().insertAll(TodoEntity(id,username, pass))
                Toast.makeText(this, "Registration successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Password is not correct", Toast.LENGTH_LONG).show()
            }
        }
        btn_cancel.setOnClickListener {
            finish()
        }


        }


}
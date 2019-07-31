package com.example.myfirstcloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.content_login.*

class ActivityLogin : AppCompatActivity() {
    private lateinit var editText: EditText
   override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonLogin.setOnClickListener {
            input()
        }
        btn_need_account.setOnClickListener {
            var intent = Intent(this, ActivityRegistration::class.java)
            startActivity(intent)
        }
    }

    fun input() {
        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,"user-list.db"
        ).build()
        buttonLogin.setOnClickListener {
            editText = findViewById(R.id.inputUsername) as EditText
            val username = editText.text.toString()
            editText = findViewById(R.id.inputPassword) as EditText
            val password = editText.text.toString()
            val tempPass : String = db.todoDao().findPassByUsername(username)
            if (password.equals(tempPass)) {
                var intent = Intent(this, ActivityList::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

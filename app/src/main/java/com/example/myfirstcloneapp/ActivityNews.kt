package com.example.myfirstcloneapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news.*


class ActivityNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var fileName = "STORE_DATA"
        val prefs: SharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE)
        val checkHeart : Boolean = prefs.getBoolean("HEARTED", false)
        val checkStar : Boolean = prefs.getBoolean("STARED", false)
        val news: String? = prefs.getString("CONTENT", "false")
        val mainImage: Int = prefs.getInt("IMAGE_RESOURCE",0)
        val titleText : String? = prefs.getString("TITLE", null)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        btn_ic_close.setOnClickListener {
            finish()
        }
        val newsTitle : TextView = findViewById(R.id.title_news)
        val heartEmotion : CheckBox = findViewById(R.id.heartIcon)
        val starEmotion : CheckBox = findViewById(R.id.starIcon)
        val imageResoure : ImageView = findViewById(R.id.imageView)
        val newsContent : TextView = findViewById(R.id.content)

        imageResoure.setImageResource(mainImage)
        newsTitle.text =titleText
        newsContent.text = news
        heartEmotion.setChecked(checkHeart)
        starEmotion.setChecked(checkStar)


    }
}


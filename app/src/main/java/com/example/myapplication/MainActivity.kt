package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val title:TextView = findViewById(R.id.titleTextView)
//        val learnMoreButton: Button = findViewById(R.id.learnMoreButton)
//        learnMoreButton.setOnClickListener {
//            // todo navigate
//            val intent = Intent(it.context, DetailActivity::class.java)
//            val title = title.text.toString()
//            intent.putExtra("title",title)
//            startActivity(intent)
//        }
    }
}
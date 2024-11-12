package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val learnMoreButton: Button = findViewById(R.id.learnMoreButton)
        learnMoreButton.setOnClickListener {
            // todo navigate
            val intent = Intent(it.context, DetailActivity::class.java )
            startActivity(intent)
        }
    }
}
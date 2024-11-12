package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.bottomButton)
        val inputEditText: EditText = findViewById(R.id.inputEditText)
        button.setOnClickListener {
            //Toast.makeText(it.context, inputEditText.text.toString(), Toast.LENGTH_SHORT).show()
            if (inputEditText.text.toString().isEmpty())
                return@setOnClickListener
            Snackbar.make(it,inputEditText.text.toString(),Snackbar.LENGTH_SHORT).show()
        }
    }
}
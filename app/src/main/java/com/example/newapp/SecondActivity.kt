package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editText = findViewById<EditText>(R.id.editText)

        if (intent.extras != null) {
            val firstText = intent.extras!!.getString("firstText")
            if (firstText != null) {
                findViewById<TextView>(R.id.firstText).text = firstText
                editText.setText(firstText)
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("secondText", editText.text.toString())
            startActivity(intent)
        }
    }
}
package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val editText = findViewById<EditText>(R.id.editText)

        if (intent.extras != null) {
            var secondText = intent.extras!!.getString("secondText")
            if (secondText != null) {
                findViewById<TextView>(R.id.secondText).text = secondText
                editText.setText(secondText)
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("firstText", editText.text.toString())
            startActivity(intent)
        }
    }
}
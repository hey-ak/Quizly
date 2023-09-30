package com.example.quizly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        setContentView(R.layout.activity_splashscreen)
        val buttonStart: Button = findViewById(R.id.btnstart)
        val editText: EditText = findViewById(R.id.etText)

        buttonStart.setOnClickListener {
            if (editText.text.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,QuizQuestionScreen::class.java)
                startActivity(intent)
//                finish()
            }
        }
    }
}

package com.example.quizly

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.TextView

class ScoreScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_screen) // Assuming your XML layout name is activity_scorescreen

        val scoreTextView: TextView = findViewById(R.id.score_text_view)
        val retakeButton: MaterialButton = findViewById(R.id.retake_button)
        val mainMenuButton: MaterialButton = findViewById(R.id.main_menu_button)

        // Get score from intent and display
        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TSCORE", 1) // Avoiding division by zero
        scoreTextView.text = "$score/$totalQuestions"

        // Button to retake the quiz
        retakeButton.setOnClickListener {
            val intent = Intent(this, QuizQuestionScreen::class.java)
            startActivity(intent)
            finish()
        }

        // Button to return to the main menu
        mainMenuButton.setOnClickListener {
            val intent = Intent(this, WelcomeScreen::class.java) // Assuming your main activity is named MainActivity
            startActivity(intent)
            finish()
        }
    }
}

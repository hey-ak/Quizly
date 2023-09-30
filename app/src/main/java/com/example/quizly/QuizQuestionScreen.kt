package com.example.quizly

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class QuizQuestionScreen : AppCompatActivity() {

    private var questionIndex = 0
    private var selectedOptionCard: MaterialCardView? = null
    private var correctAnswersCount = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestionscreen)

        val optionCardOne: MaterialCardView = findViewById(R.id.option_card_one)
        val optionCardTwo: MaterialCardView = findViewById(R.id.option_card_two)
        val optionCardThree: MaterialCardView = findViewById(R.id.option_card_three)
        val optionCardFour: MaterialCardView = findViewById(R.id.option_card_four)
        val submitButton: MaterialButton = findViewById(R.id.submit_button)
        val nextButton: MaterialButton = findViewById(R.id.next_button)

        val cards = listOf(optionCardOne, optionCardTwo, optionCardThree, optionCardFour)

        cards.forEach { card ->
            card.setOnClickListener {
                clearPreviousSelection()
                card.setStrokeWidth(2)
                card.setStrokeColor(Color.parseColor("#8C6200EE"))
                selectedOptionCard = card
            }
        }

        loadQuestion()
        nextButton.isEnabled = false

        submitButton.setOnClickListener {
            if (selectedOptionCard != null) {
                val selectedOptionIndex = cards.indexOf(selectedOptionCard)

                if (selectedOptionIndex == Constants.getQuestions()[questionIndex].correctAnswerIndex) {
                    selectedOptionCard?.setStrokeColor(ContextCompat.getColor(this, R.color.correct_answer))
                    correctAnswersCount++ // Increment the count of correct answers
                } else {
                    selectedOptionCard?.setStrokeColor(ContextCompat.getColor(this, R.color.wrong_answer))
                    cards[Constants.getQuestions()[questionIndex].correctAnswerIndex].setStrokeColor(ContextCompat.getColor(this, R.color.correct_answer))
                }
                nextButton.isEnabled = true
            }
        }


        nextButton.setOnClickListener {
            questionIndex++
            if (questionIndex < Constants.getQuestions().size) {
                loadQuestion()
                nextButton.isEnabled = false
            } else {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("SCORE", correctAnswersCount) // Pass the total number of correct answers
                intent.putExtra("TSCORE",Constants.getQuestions().size) // Pass the total number of correct answers
                startActivity(intent)
                finish()
            }
        }


    }

// ... [The beginning of your code remains unchanged]

    private fun loadQuestion() {
        val currentQuestion = Constants.getQuestions()[questionIndex]

        // Update the question text
        val questionTextView: TextView = findViewById(R.id.question_text_view)
        questionTextView.text = "${questionIndex+1}. ${currentQuestion.questionText}"


        // Update the options
        val optionOneTextView: TextView = findViewById(R.id.option_one)
        optionOneTextView.text = "1  ${currentQuestion.options[0]}"

        val optionTwoTextView: TextView = findViewById(R.id.option_two)
        optionTwoTextView.text = "2  ${currentQuestion.options[1]}"

        val optionThreeTextView: TextView = findViewById(R.id.option_three)
        optionThreeTextView.text = "3  ${currentQuestion.options[2]}"

        val optionFourTextView: TextView = findViewById(R.id.option_four)
        optionFourTextView.text = "4  ${currentQuestion.options[3]}"

        // Reset the colors for options
        clearPreviousSelection()
    }

// ... [The rest of your code remains unchanged]


    private fun clearPreviousSelection() {
        listOf(findViewById<MaterialCardView>(R.id.option_card_one),
            findViewById<MaterialCardView>(R.id.option_card_two),
            findViewById<MaterialCardView>(R.id.option_card_three),
            findViewById<MaterialCardView>(R.id.option_card_four)).forEach { card ->
            card.setStrokeWidth(0)
            card.setStrokeColor(Color.TRANSPARENT)
        }
        selectedOptionCard = null
    }
}

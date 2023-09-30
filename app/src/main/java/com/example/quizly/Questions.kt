package com.example.quizly

data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)



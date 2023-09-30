// Constants.kt
package com.example.quizly

object Constants {

    fun getQuestions(): List<Question> {
        return listOf(
            Question(1, "What's the capital of France?", listOf("Berlin", "Madrid", "Paris", "Rome"), 2),
            Question(2, "Which planet is known as the Red Planet?", listOf("Earth", "Mars", "Jupiter", "Venus"), 1),
            Question(3, "How many continents are there?", listOf("5", "6", "7", "8"), 2),
            Question(4, "Which gas do plants absorb from the atmosphere?", listOf("Carbon Dioxide", "Oxygen", "Nitrogen", "Helium"), 0),
            Question(5, "What's the largest mammal?", listOf("Elephant", "Blue Whale", "Giraffe", "Lion"), 1),
            Question(6, "Which element has the chemical symbol 'Au'?", listOf("Silver", "Gold", "Aluminum", "Iron"), 1),
            Question(7, "Who wrote 'Romeo and Juliet'?", listOf("Charles Dickens", "Leo Tolstoy", "William Shakespeare", "Jane Austen"), 2),
            Question(8, "In which year did World War II end?", listOf("1942", "1945", "1950", "1948"), 1),
            Question(9, "What's the smallest prime number?", listOf("0", "1", "2", "3"), 2),
            Question(10, "Which of these is not a planet?", listOf("Pluto", "Neptune", "Saturn", "Uranus"), 0)
        )
    }
}

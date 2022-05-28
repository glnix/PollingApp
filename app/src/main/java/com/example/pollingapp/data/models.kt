package com.example.pollingapp.data

data class Poll(val id: Int, val name: String, val questions: List<Question>)

data class Question(val id: Int, val title: String, val answers: List<Answer>)

data class Answer(val id: Int, val title: String, var isChecked: Boolean = false)

data class Profile(
    val name: String,
    val middleName: String,
    val lastName: String,
    val birthday: String,
    val institute: String,
    val profile: String,
    val group: String,
    val year: String,
    val specialization: String,
    val period: String,
    val email: String,
    val phone: String

)

fun Poll.isFull(): Boolean {
    questions.forEach {
        if (it.answers.none { it.isChecked } ) return false
    }
    return true
}
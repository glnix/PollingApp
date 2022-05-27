package com.example.pollingapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Poll(val id: Int, val name: String, val questions: List<Question>) : Parcelable

@Parcelize
data class Question(val id: Int, val title: String, val answers: List<Answer>) : Parcelable

@Parcelize
data class Answer(val id: Int, val title: String, var isChecked: Boolean = false) : Parcelable

@Parcelize
data class Profile(val name: String, val birthday: String, val specialization: String) : Parcelable
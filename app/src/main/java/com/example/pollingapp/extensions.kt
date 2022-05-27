package com.example.pollingapp

import android.widget.EditText
import kotlin.random.Random

fun EditText.setTextWithDefaultTag(newText: String) {
    tag = Random.nextInt().toString()
    setText(newText)
    setSelection(length())
    tag = null
}
package com.example.pollingapp.data.repository

import android.content.Context
import com.example.pollingapp.data.Poll
import com.google.gson.Gson

class PollsRepository(context: Context) {

    private val POLLS_CODE = "POLLS_CODE"
    private val prefs = context.getSharedPreferences(POLLS_CODE, Context.MODE_PRIVATE)


    fun savePoll(poll: Poll) {
        prefs.edit()
            .putString("$POLLS_CODE+${poll.id}", Gson().toJson(poll)).apply()
    }

    fun getSavedPollById(id: Int): Poll {
        val saved = Gson().fromJson(prefs.getString("$POLLS_CODE+$id", null), Poll::class.java)
        return saved ?: loadPolls().find { it.id == id }!!
    }

    fun loadPolls() = getPolls()
}

package com.example.pollingapp.data.repository

import android.content.Context
import com.example.pollingapp.data.Poll
import com.example.pollingapp.data.isFull
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
        return saved ?: getDefaultPollById(id)

    }

    private fun getDefaultPollById(id: Int)  = getPolls().find { it.id == id }!!

    fun loadPolls(): List<Poll> {
        val initPolls = getPolls()
        val updatedPolls = mutableListOf<Poll>()
        initPolls.forEach {
            updatedPolls.add(getSavedPollById(it.id))
        }

        return updatedPolls.apply { sortBy { it.isFull() } }
    }
}

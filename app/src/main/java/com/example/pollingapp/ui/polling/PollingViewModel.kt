package com.example.pollingapp.ui.polling

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pollingapp.data.Poll
import com.example.pollingapp.data.repository.PollsRepository

class PollingViewModel : ViewModel() {

    val pollLiveData = MutableLiveData<Poll>()

    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context

    fun setContext(ctx: Context) {
        context = ctx
    }

    fun loadPoll(id: Int) {
        val poll = PollsRepository(context).getSavedPollById(id)
        pollLiveData.value = poll
    }

    fun setAnswer(questionId: Int, answerId: Int, isChecked: Boolean) {
        val targetQuestion = pollLiveData.value?.questions?.find { it.id == questionId }
        val targetAnswer = targetQuestion?.answers?.find { it.id == answerId }

        targetAnswer?.isChecked = isChecked
    }

    fun submit() {
       PollsRepository(context).savePoll(pollLiveData.value!!)
    }

}
package com.example.pollingapp.ui.polls

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pollingapp.data.Poll
import com.example.pollingapp.data.repository.PollsRepository

class PollsViewModel : ViewModel() {
    val pollsLiveData = MutableLiveData<List<Poll>>()

    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context

    fun setContext(ctx: Context) {
        context = ctx
    }

    fun loadPolls() {
        pollsLiveData.value = PollsRepository(context).loadPolls()
    }

}
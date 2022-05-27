package com.example.pollingapp.ui.profile

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.*
import com.example.pollingapp.data.Profile
import com.example.pollingapp.data.repository.UserRepository

class ProfileViewModel : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context
    val state: MutableLiveData<Profile> = MutableLiveData(Profile("", "", ""))

    fun setContext(ctx: Context) {
        context = ctx
    }

    fun loadProfile() {
        state.value = UserRepository(context).loadProfile()
    }

    fun onNameChanged(name: String) {
        state.value = state.value?.copy(name = name)
        state.value?.let { UserRepository(context).saveProfile(it) }
    }

    fun onBirthdayChanged(date: String) {
        state.value = state.value?.copy(birthday = date)
        state.value?.let { UserRepository(context).saveProfile(it) }
    }

    fun onSpecializationChanged(specialization: String) {
        state.value = state.value?.copy(specialization = specialization)
        state.value?.let { UserRepository(context).saveProfile(it) }
    }
}
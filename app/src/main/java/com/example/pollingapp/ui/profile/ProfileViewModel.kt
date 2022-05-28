package com.example.pollingapp.ui.profile

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.*
import com.example.pollingapp.data.Profile
import com.example.pollingapp.data.repository.UserRepository

class ProfileViewModel : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context
    val state: MutableLiveData<Profile> = MutableLiveData<Profile>()

    fun setContext(ctx: Context) {
        context = ctx
    }

    fun loadProfile() {
        state.value = UserRepository(context).loadProfile()
    }

    fun onPhoneChanged(phone: String) {
        state.value = state.value?.copy(phone = phone)
        state.value?.let { UserRepository(context).saveProfile(it) }
    }

    fun onEmailChanged(email: String) {
        state.value = state.value?.copy(email = email)
        state.value?.let { UserRepository(context).saveProfile(it) }
    }
}
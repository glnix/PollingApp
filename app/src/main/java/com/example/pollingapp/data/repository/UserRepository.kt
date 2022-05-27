package com.example.pollingapp.data.repository

import android.content.Context
import com.example.pollingapp.data.Profile
import com.google.gson.Gson

class UserRepository(context: Context) {

    private val PREFS_CODE = "PREFS_CODE"
    private val PROFILE_CODE = "PROFILE_CODE"
    private val prefs = context.getSharedPreferences(PREFS_CODE, Context.MODE_PRIVATE)

    fun saveProfile(profile: Profile) {
        prefs.edit()
            .putString(PROFILE_CODE, Gson().toJson(profile)).apply()
    }

    fun loadProfile(): Profile {
        val resultProfile = Gson().fromJson(prefs.getString(PROFILE_CODE, null), Profile::class.java)
        return when(resultProfile) {
            null -> Profile("", "", "")
            else -> resultProfile
        }
    }
}
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
        return when(val resultProfile = Gson().fromJson(prefs.getString(PROFILE_CODE, null), Profile::class.java)) {
            null -> initProfile()
            else -> resultProfile
        }
    }

    private fun initProfile() = Profile(
        name = "Имя: Полина",
        middleName = "Отчество: Руслановна",
        lastName = "Фамилия: Умеркаева",
        birthday = "Дата рождения: 13.03.2000",
        institute = "Институт: Инфокоммуникационных систем и технологий",
        specialization = "Специальность/направление подготовки: Прикладная математика и информатика",
        profile = "Профиль/специализация/направленность: Программирование, математическое моделирование",
        group = "Группа: ПМИ-18",
        year = "Год поступления: 2018",
        period = "Период обучения: 4 года",
        email = "",
        phone = "",
    )
}
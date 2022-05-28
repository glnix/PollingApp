package com.example.pollingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.pollingapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val USERNAMAE = "polina"
    private val PASSWORD = "11111"
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.login.setOnClickListener {
            checkCredentials()
        }
    }

    private fun checkCredentials() {
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()
        if (username == USERNAMAE && password == PASSWORD) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, R.string.error_login, Toast.LENGTH_SHORT).show()
        }
    }

}
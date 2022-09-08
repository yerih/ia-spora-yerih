package com.spora.corrutinas.login.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spora.corrutinas.databinding.ActivityLoginBinding
import com.spora.corrutinas.main.presentation.activities.MainActivity

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }
        }
    }
}
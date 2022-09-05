package com.spora.corrutinas.main.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spora.corrutinas.databinding.ActivityRegisterBinding
import com.spora.corrutinas.main.presentation.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private var mViewModel = RegisterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = ActivityRegisterBinding.inflate(layoutInflater).apply {
            btnRegisterCancel.setOnClickListener { mViewModel.onCancelClicked() }
            btnRegisterSend.setOnClickListener { mViewModel.onSendClicked(this) }
        }
        setContentView(binding.root)
    }
}
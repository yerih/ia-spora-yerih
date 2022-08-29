package com.spora.corrutinas.main.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.spora.corrutinas.R
import com.spora.corrutinas.main.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        viewModel.requestData()
    }
}
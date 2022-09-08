package com.spora.corrutinas.DB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spora.corrutinas.R
import com.spora.corrutinas.databinding.ActivityDbactivityBinding

class DBActivity : AppCompatActivity() {
    private var _binding: ActivityDbactivityBinding? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbactivity)
    }
}
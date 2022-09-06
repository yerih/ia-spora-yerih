package com.spora.corrutinas.main.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.spora.corrutinas.databinding.ActivityMainBinding
import com.spora.corrutinas.main.domain.datasourceabstrations.ItemsProvider
import com.spora.corrutinas.main.presentation.adapters.MainAdapter
import com.spora.corrutinas.main.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = MainAdapter()
    private val observer = { list: List<String> -> adapter.submitList(list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ItemsProvider.startEmitting(observer)
        binding.recycler.adapter = adapter
        binding.onClick = { Toast.makeText(applicationContext, "button clicked", Toast.LENGTH_SHORT).show() }
    }

    override fun onDestroy() {
        ItemsProvider.observable.unsuscribe(observer)
        super.onDestroy()
    }
}
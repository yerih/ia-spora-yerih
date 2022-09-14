package com.spora.corrutinas.db.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.room.Room
import com.spora.corrutinas.db.data.Contact
import com.spora.corrutinas.db.data.ContactDatabase
import com.spora.corrutinas.R
import com.spora.corrutinas.databinding.ActivityDbBinding
import com.spora.corrutinas.db.presentation.viewmodels.DbViewModel

class DBActivity : AppCompatActivity() {

    private val db by lazy {
        Room.databaseBuilder(applicationContext, ContactDatabase::class.java, Contact.table_name).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val viewModel: DbViewModel by viewModels<DbViewModel>().apply { value.contactDao = db.contactDao() }
        val binding = ActivityDbBinding.inflate(layoutInflater).apply {
            btnDbSend.setOnClickListener { viewModel.onSendClicked() }
        }
        setContentView(binding.root)
    }
}
package com.spora.corrutinas.db.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.spora.corrutinas.db.data.Contact
import com.spora.corrutinas.db.data.ContactDatabase
import com.spora.corrutinas.databinding.ActivityDbBinding
import com.spora.corrutinas.db.presentation.adapters.DbAdapter
import com.spora.corrutinas.db.presentation.viewmodels.DbViewModel
import kotlinx.coroutines.launch

class DBActivity : AppCompatActivity() {

    private val db by lazy {
        Room.databaseBuilder(applicationContext, ContactDatabase::class.java, Contact.table_name).build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val viewModel: DbViewModel by viewModels<DbViewModel>().apply { value.contactDao = db.contactDao() }
        val adapter = DbAdapter{ contact, isDelete -> viewModel.saveOrDelete(contact, isDelete) }
        val binding = ActivityDbBinding.inflate(layoutInflater).apply {
            recycler.adapter = adapter
            btnDbSend.setOnClickListener { viewModel.onSendClicked(this) }
        }
        lifecycleScope.launch { db.contactDao().getContacts().collect{ adapter.submitList(it) } }
        setContentView(binding.root)
    }
}
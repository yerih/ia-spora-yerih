package com.spora.corrutinas.db.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spora.corrutinas.db.data.Contact
import com.spora.corrutinas.db.data.ContactDao
import com.spora.corrutinas.db.data.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DbViewModel : ViewModel(){

    lateinit var contactDao: ContactDao


    fun onSendClicked() {
//        viewModelScope.launch(Dispatchers.IO) { contactDao.insert(Contact("hola", "como", true)) }
        viewModelScope.launch(Dispatchers.IO) { contactDao.delete(Contact("hola", "como", true)) }
    }
}
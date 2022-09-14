package com.spora.corrutinas.db.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spora.corrutinas.databinding.ActivityDbBinding
import com.spora.corrutinas.databinding.ItemDbBinding
import com.spora.corrutinas.db.data.Contact
import com.spora.corrutinas.db.data.ContactDao
import com.spora.corrutinas.db.data.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DbViewModel : ViewModel(){

    lateinit var contactDao: ContactDao


    fun onSendClicked(binding: ActivityDbBinding) {
        with(binding){
            val name = inputName.text.toString()
            val last = inputLast.text.toString()
            val error = "check empty field"
            var check = true
            if(name.isNotEmpty())layoutName.isErrorEnabled = false else layoutName.error = error.also { check = false }
            if(last.isNotEmpty())layoutLast.isErrorEnabled = false else layoutLast.error = error.also { check = false }
            if(check) viewModelScope.launch(Dispatchers.IO) {
                contactDao.insert(Contact(name, last, radioBtnIsMale.isChecked))
//                contactDao.insert(Contact("hola", "como", true))
            }
        }
    }

    fun saveOrDelete(contact: Contact, isDelete: Boolean) {
        when{
            isDelete -> viewModelScope.launch(Dispatchers.IO) { contactDao.delete(contact) }
            else     -> {}
        }
    }
}
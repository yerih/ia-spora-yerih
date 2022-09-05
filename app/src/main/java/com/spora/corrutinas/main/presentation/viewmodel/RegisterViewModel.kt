package com.spora.corrutinas.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spora.corrutinas.databinding.ActivityRegisterBinding
import com.spora.corrutinas.main.domain.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel(){

    data class RegisterData(
        var name: String = "",
        var paternal: String = "",
        var maternal: String = "",
        var email: String = "",
        var address: String = "",
        var phone: String = "",
        var date: String = "",
    )
    private val data = RegisterData()

    private fun checkInput(binding: ActivityRegisterBinding): Boolean{
        var check = true
        val error = "check empty input"
        with(binding){
            with(data){
                name = inputName.text.toString().also { check = false}
                paternal = inputPaternal.text.toString().also { check = false }
                maternal = inputMaternal.text.toString().also { check = false }
                phone = inputPhone.text.toString().also { check = false }
                date = inputDate.text.toString().also { check = false }
                email = inputEmail.text.toString().also { check = false }

                if(name.isNotEmpty()) layoutName.isErrorEnabled = false else layoutName.error = error
                if(paternal.isNotEmpty()) layoutPaternal.isErrorEnabled = false else layoutPaternal.error = error
                if(maternal.isNotEmpty()) layoutMaternal.isErrorEnabled = false else layoutMaternal.error = error
                if(phone.isNotEmpty()) layoutPhone.isErrorEnabled = false else layoutPhone.error = error
                if(date.isNotEmpty()) layoutDate.isErrorEnabled = false else layoutDate.error = error
                if(email.isNotEmpty()) layoutEmail.isErrorEnabled = false else layoutEmail.error = error
                if(address.isNotEmpty()) layoutAddress.isErrorEnabled = false else layoutAddress.error = error
            }
        }
        return check
    }

    fun onSendClicked(binding: ActivityRegisterBinding){
        if(!checkInput(binding))return
    }

    fun onCancelClicked(){}
}
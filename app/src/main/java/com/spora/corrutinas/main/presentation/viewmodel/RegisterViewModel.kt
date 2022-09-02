package com.spora.corrutinas.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spora.corrutinas.databinding.ActivityRegisterBinding
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
        with(binding){
            with(data){
                name = inputName.text.toString().ifEmpty { check = false}
                paternal = inputPaternal.text.toString().also { check = false }
                maternal = inputMaternal.text.toString().also { check = false }
                phone = inputPhone.text.toString().also { check = false }
                date = inputDate.text.toString().also { check = false }
                email = inputEmail.text.toString().also { check = false }
            }
            layoutName.isErrorEnabled = .isEmpty().also { if(it)check = it }
        }
        return check
    }

    fun onSendClicked(binding: ActivityRegisterBinding){
        if(!checkInput(binding))return
    }

    fun onCancelClicked(){}
}
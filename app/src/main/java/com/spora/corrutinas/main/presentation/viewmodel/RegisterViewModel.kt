package com.spora.corrutinas.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){

    fun requestData(){
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}
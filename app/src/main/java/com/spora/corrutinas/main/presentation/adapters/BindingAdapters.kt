package com.spora.corrutinas.main.presentation.adapters

import androidx.databinding.BindingAdapter
import com.spora.corrutinas.main.presentation.components_ui.ButtonTimer

@BindingAdapter("listener")
fun ButtonTimer.setClickListener(listener: ()->Unit) {
    clickListener?.let {
        if(listener != clickListener)clickListener = listener
    }?:run{
        clickListener = listener
    }
    callOnClick()
}


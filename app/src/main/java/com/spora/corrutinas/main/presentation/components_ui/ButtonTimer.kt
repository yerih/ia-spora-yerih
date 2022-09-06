package com.spora.corrutinas.main.presentation.components_ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.os.CountDownTimer
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton
import com.spora.corrutinas.R
import java.util.concurrent.TimeUnit

class ButtonTimer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.style.SporaButton,
): MaterialButton(context, attrs, defStyleAttr){

    private var time: Int = 0
    private var textOff: String = ""
    private var textOn: String = ""
    var clickListener: (()->Unit)? = null
    private var timer: CountDownTimer

    init {
        context.obtainStyledAttributes(attrs, R.styleable.StyleButtonTimer).apply {
            time = getInt(R.styleable.StyleButtonTimer_time, 0).also { timer = buildTimer() }
            textOff = getString(R.styleable.StyleButtonTimer_textOff).toString().also { text = it }
            textOn = getString(R.styleable.StyleButtonTimer_textOn).toString()
            recycle()
        }
        setOnClickListener {
            isEnabled = false
            timer.start()
            clickListener?.invoke()
        }
    }

    private fun buildTimer() = object : CountDownTimer((time * 1000).toLong(), 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(milis: Long) {
            val seconds = (TimeUnit.MILLISECONDS.toSeconds(milis) + 1).toString()
            text = "$textOn: $seconds s"
        }
        override fun onFinish() { isEnabled = true; text = textOff; }
    }

}

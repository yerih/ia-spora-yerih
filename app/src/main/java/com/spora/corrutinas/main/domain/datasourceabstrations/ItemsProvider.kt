package com.spora.corrutinas.main.domain.datasourceabstrations

import com.spora.corrutinas.main.presentation.observable.MainObservable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

object ItemsProvider {
    val observable = MainObservable<List<String>>(emptyList())
    private var values = emptyList<String>()
    private val random = Random(System.currentTimeMillis())

    fun startEmitting(onUpdate: (List<String>)->Unit) = GlobalScope.launch(Dispatchers.Main) {
        observable.suscribe(onUpdate)
        for (num in 0 .. 9){
            delay(1000)
            values = values + random.nextInt().toString()
            observable.updateValue(values)
        }
    }
}
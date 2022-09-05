package com.spora.corrutinas.main.presentation.observable

class MainObservable<T>(var value: T){
    private val observers: MutableList<(T)->Unit> = mutableListOf()

    fun suscribe(observer: (T)->Unit) = observers.add(observer)
    fun unsuscribe(observer: (T)->Unit){ observers.remove(observer)}
    fun updateValue(newValue: T){ value = newValue;observers.forEach{ it(value) } }
}


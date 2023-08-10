package com.example.myviewsapp.view

abstract class BaseObservableViewMvc<ListenerType>: BaseViewMvc(), ObservableViewMvc<ListenerType> {

    private val listeners = mutableSetOf<ListenerType>()

    override fun registerListener(listener: ListenerType) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        listeners.remove(listener)
    }

    protected fun getListeners(): Set<ListenerType> {
        return listeners.toSet()
    }
}
package com.example.myviewsapp.view

interface ObservableViewMvc<ListenerType>: ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)

}
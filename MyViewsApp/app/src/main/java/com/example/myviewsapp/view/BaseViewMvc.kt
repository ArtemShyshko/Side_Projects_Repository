package com.example.myviewsapp.view

import android.content.Context
import android.view.View

abstract class BaseViewMvc: ViewMvc {

    private lateinit var rootView: View

    protected fun setRootView(view: View) {
        rootView = view
    }

    protected fun findViewById(id: Int): View {
        return getRootView().findViewById(id)
    }

    fun getContext(): Context {
        return getRootView().context
    }

    override fun getRootView(): View {
        return rootView
    }
}
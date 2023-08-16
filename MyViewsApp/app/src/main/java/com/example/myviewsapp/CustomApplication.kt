package com.example.myviewsapp

import android.app.Application
import com.example.myviewsapp.common.dependencyinjection.CompositionRoot

class CustomApplication : Application() {

    private lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = CompositionRoot()
    }

    fun getCompositionRoot() : CompositionRoot {
        return compositionRoot
    }

}
package com.example.myviewsapp.view

import androidx.appcompat.app.AppCompatActivity
import com.example.myviewsapp.CustomApplication
import com.example.myviewsapp.common.dependencyinjection.ControllerCompositionRoot

abstract class BaseActivity : AppCompatActivity() {

    lateinit var compositionRoot: ControllerCompositionRoot

    protected fun getControllerCompositionRoot() : ControllerCompositionRoot {
        val app = application as CustomApplication
        compositionRoot = ControllerCompositionRoot(app.getCompositionRoot(), this)
        return compositionRoot
    }

}
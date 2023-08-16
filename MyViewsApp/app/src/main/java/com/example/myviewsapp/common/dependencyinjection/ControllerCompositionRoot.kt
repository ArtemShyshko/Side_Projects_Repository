package com.example.myviewsapp.common.dependencyinjection

import android.app.Activity
import android.view.LayoutInflater
import com.example.myviewsapp.model.CountriesApi
import com.example.myviewsapp.view.common.ViewMvcFactory

class ControllerCompositionRoot(
    private val compositionRoot: CompositionRoot,
    private val activity: Activity
) {

    private fun getLayoutInflater() = LayoutInflater.from(activity)

    fun getCountriesApi() = compositionRoot.getCountriesApi()

    fun getViewMvcFactory() = ViewMvcFactory(getLayoutInflater())

}
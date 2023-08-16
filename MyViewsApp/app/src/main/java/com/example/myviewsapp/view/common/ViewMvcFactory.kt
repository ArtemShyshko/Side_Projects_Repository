package com.example.myviewsapp.view.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myviewsapp.view.CountryItemViewMvc
import com.example.myviewsapp.view.CountriesListViewMvc
import com.example.myviewsapp.view.CountriesListViewMvcImpl
import com.example.myviewsapp.view.CountryItemViewMvcImpl

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun getCountriesListViewMvc(parent: ViewGroup?): CountriesListViewMvc {
        return CountriesListViewMvcImpl(layoutInflater, parent, this)
    }

    fun getCountryItemViewMvc(parent: ViewGroup?): CountryItemViewMvc {
        return CountryItemViewMvcImpl(layoutInflater, parent)
    }

}
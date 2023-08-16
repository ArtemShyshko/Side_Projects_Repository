package com.example.myviewsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myviewsapp.model.CountriesApi

class CountriesViewModelFactory(private val api: CountriesApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountriesViewModel::class.java)) {
            return CountriesViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
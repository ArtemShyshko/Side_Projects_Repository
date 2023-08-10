package com.example.myviewsapp.view

import com.example.myviewsapp.Country

interface CountriesItemViewMvc: ObservableViewMvc<CountriesItemViewMvc.Listener> {

    interface Listener {
        fun onCountryClicked(country: Country)
    }

    fun bindCountry(country: Country)
}
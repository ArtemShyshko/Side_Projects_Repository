package com.example.myviewsapp.view

import com.example.myviewsapp.Country

interface CountryItemViewMvc: ObservableViewMvc<CountryItemViewMvc.Listener> {

    interface Listener {
        fun onCountryClicked(country: Country)
    }

    fun bindCountry(country: Country)
}
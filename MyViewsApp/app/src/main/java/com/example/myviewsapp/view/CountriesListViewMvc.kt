package com.example.myviewsapp.view

import com.example.myviewsapp.Country

interface CountriesListViewMvc: ObservableViewMvc<CountriesListViewMvc.Listener> {

    interface Listener {
        fun onListViewMvcRefreshed()
        fun onCountryClicked(country: Country)
    }

    fun bindCountries(countries: List<Country>)

    fun setLoadError(isError: Boolean)

    fun setLoading(isLoading: Boolean)
}
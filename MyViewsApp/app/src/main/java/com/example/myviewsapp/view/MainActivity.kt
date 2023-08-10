package com.example.myviewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myviewsapp.Country
import com.example.myviewsapp.viewmodel.ListViewModel

class MainActivity : BaseActivity() {

    private inner class ViewMvcEventsListener : CountriesListViewMvc.Listener {

        override fun onListViewMvcRefreshed() {
            viewModel.refresh()
        }

        override fun onCountryClicked(country: Country) {
            Toast.makeText(
                countriesListViewMvc.getContext(),
                country.countryName + " " + country.capital,
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private lateinit var viewModel: ListViewModel
    private lateinit var countriesListViewMvc: CountriesListViewMvcImpl

    private val viewMvcEventsListener = ViewMvcEventsListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        countriesListViewMvc = CountriesListViewMvcImpl(LayoutInflater.from(this), null)
        countriesListViewMvc.registerListener(viewMvcEventsListener)
        setContentView(countriesListViewMvc.getRootView())

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()

        observeViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        countriesListViewMvc.unregisterListener(viewMvcEventsListener)
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this) { countries ->
            countries?.let {
                countriesListViewMvc.bindCountries(it)
            }
        }

        viewModel.countryLoadError.observe(this) { isError ->
            isError?.let {
                countriesListViewMvc.setLoadError(it)
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            isLoading?.let {
                countriesListViewMvc.setLoading(it)
            }
        }
    }
}
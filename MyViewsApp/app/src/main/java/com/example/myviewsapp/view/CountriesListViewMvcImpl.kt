package com.example.myviewsapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myviewsapp.Country
import com.example.myviewsapp.R
import com.example.myviewsapp.view.common.ViewMvcFactory

class CountriesListViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) :
    BaseObservableViewMvc<CountriesListViewMvc.Listener>(), CountriesListViewMvc {

    private inner class ItemEventsListener : CountryItemViewMvc.Listener {
        override fun onCountryClicked(country: Country) {
            getListeners().forEach { listener -> listener.onCountryClicked(country) }
        }
    }

    private var swipeRefreshLayout: SwipeRefreshLayout
    private var countriesList: RecyclerView
    private var listErrorView: TextView
    private var listLoadingView: ProgressBar

    private val countriesAdapter =
        CountryListAdapter(arrayListOf(), ItemEventsListener(), viewMvcFactory)

    init {
        setRootView(inflater.inflate(R.layout.activity_main, parent, false))
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        countriesList = findViewById(R.id.countries_list) as RecyclerView
        listErrorView = findViewById(R.id.list_error) as TextView
        listLoadingView = findViewById(R.id.loading_view) as ProgressBar

        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        swipeRefreshLayout.setOnRefreshListener {
            getListeners().forEach { listener -> listener.onListViewMvcRefreshed() }
            swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun setLoadError(isError: Boolean) {
        listErrorView.visibility = if (isError) View.VISIBLE else View.GONE
    }

    override fun setLoading(isLoading: Boolean) {
        listLoadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
        if (isLoading) {
            listErrorView.visibility = View.GONE
            countriesList.visibility = View.GONE
        }
    }

    override fun bindCountries(countries: List<Country>) {
        countriesList.visibility = View.VISIBLE
        countriesAdapter.updateCountries(countries)
    }

}
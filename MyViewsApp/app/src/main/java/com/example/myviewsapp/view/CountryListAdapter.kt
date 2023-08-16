package com.example.myviewsapp.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myviewsapp.Country
import com.example.myviewsapp.view.common.ViewMvcFactory

class CountryListAdapter(
    private var countries: ArrayList<Country>,
    private val listener: CountryItemViewMvc.Listener,
    private val viewMvcFactory: ViewMvcFactory
) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val view: CountryItemViewMvc): RecyclerView.ViewHolder(view.getRootView()) {
        fun bind(country: Country) {
            view.bindCountry(country)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CountryViewHolder {
        val itemView = viewMvcFactory.getCountryItemViewMvc(parent)
        itemView.registerListener(listener)
        return CountryViewHolder(itemView)
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

}
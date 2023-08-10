package com.example.myviewsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myviewsapp.Country

class CountryListAdapter(
    private var countries: ArrayList<Country>,
    private val listener: CountriesItemViewMvc.Listener
) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val view: CountryItemViewMvcImpl): RecyclerView.ViewHolder(view.getRootView()) {
        fun bind(country: Country) {
            view.bindCountry(country)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CountryViewHolder {
        val itemView = CountryItemViewMvcImpl(LayoutInflater.from(parent.context), parent)
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
package com.example.myviewsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myviewsapp.Country
import com.example.myviewsapp.R
import com.example.myviewsapp.util.getProgressDrawable
import com.example.myviewsapp.util.loadImage

class CountryItemViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<CountryItemViewMvc.Listener>(), CountryItemViewMvc {

    private var countryName: TextView
    private var capitalName: TextView
    private var flagImage: ImageView

    init {
        setRootView(inflater.inflate(R.layout.item_country, parent, false))
        countryName = findViewById(R.id.name) as TextView
        capitalName = findViewById(R.id.capital) as TextView
        flagImage = findViewById(R.id.flag_image) as ImageView
    }

    override fun bindCountry(country: Country) {
        countryName.text = country.countryName
        capitalName.text = country.capital
        flagImage.loadImage(country.flagUrl, getProgressDrawable(getContext()))

        getRootView().setOnClickListener {
            getListeners().forEach { listener -> listener.onCountryClicked(country) }
        }
    }

}
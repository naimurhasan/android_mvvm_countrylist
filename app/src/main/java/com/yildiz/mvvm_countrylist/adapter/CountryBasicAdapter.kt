package com.yildiz.mvvm_countrylist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.yildiz.mvvm_countrylist.model.CountryModel

class CountryBasicAdapter(context: Context, private var countries: ArrayList<CountryModel>)
    : ArrayAdapter<CountryModel>(context, android.R.layout.simple_list_item_1, countries){

   private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val country = getItem(position)
        val countryName = view.findViewById<TextView>(android.R.id.text1)
        countryName.text = country?.name
        return view
    }

    fun updateCountries(newCountries: ArrayList<CountryModel>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

}
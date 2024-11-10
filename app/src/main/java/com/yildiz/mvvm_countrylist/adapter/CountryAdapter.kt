package com.yildiz.mvvm_countrylist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.decode.SvgDecoder
import coil.load
import com.yildiz.mvvm_countrylist.R
import com.yildiz.mvvm_countrylist.model.CountryModel
import com.yildiz.mvvm_countrylist.utils.ImageLoader

class CountryAdapter(private var countryList: ArrayList<CountryModel>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvCapital : TextView = itemView.findViewById(R.id.tvCapital)
        val ivFlag : ImageView = itemView.findViewById(R.id.ivFlag)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryAdapter.CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.tvName.text =  country.name

        holder.tvCapital.text = if (!country.capital.isNullOrEmpty()) {
            country.capital[0]
        }else{
            ""
        }

        val imageContext = holder.ivFlag.context
        ImageLoader.loadImage(holder.ivFlag, country.flag, imageContext)
    }

    override fun getItemCount(): Int = countryList.size

}
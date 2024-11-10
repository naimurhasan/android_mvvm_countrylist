package com.yildiz.mvvm_countrylist.model

import com.google.gson.annotations.SerializedName

data class CountryModel (
    @SerializedName("name")
    val name: String,
    val capital: List<String> = emptyList(),
    val flag: String
)
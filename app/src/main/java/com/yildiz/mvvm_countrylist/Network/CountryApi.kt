package com.yildiz.mvvm_countrylist.Network

import androidx.lifecycle.LiveData
import com.yildiz.mvvm_countrylist.model.CountryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryApi {
    // https://countryinfoapi.com/api/countries?expand=false&fields=name,flag
    @GET("api/countries")
    suspend fun getCountries(
        @Query("expand") expand: Boolean = false,
        @Query("fields") fields: String = "name,flag,capital",
    ) : ArrayList<CountryModel>;
}

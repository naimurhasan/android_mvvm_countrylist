package com.yildiz.mvvm_countrylist.Network

import androidx.lifecycle.LiveData
import com.yildiz.mvvm_countrylist.model.CountryModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CountryService {
    companion object{
        val BASE_URL = "https://countryinfoapi.com/";
    }

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val api : CountryApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryApi::class.java)

    suspend fun getCountries() : ArrayList<CountryModel>{
        return api.getCountries();
    }
}

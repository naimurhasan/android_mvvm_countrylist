package com.yildiz.mvvm_countrylist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yildiz.mvvm_countrylist.model.CountryModel

class CountryBasicListViewModel: ViewModel() {
    val countryList: MutableLiveData<ArrayList<CountryModel>> = MutableLiveData(ArrayList())

    fun refresh(){
        fetchData();
    }

    private fun fetchData() {
        val countries = arrayListOf<CountryModel>(
            CountryModel(name="USA"),
            CountryModel(name="Canada"),
            CountryModel(name="Bangladesh"),
        )
        countryList.value = countries
    }
}
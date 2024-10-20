package com.yildiz.mvvm_countrylist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yildiz.mvvm_countrylist.model.CountryModel

class CountryListViewModel: ViewModel() {
    val countryList: MutableLiveData<ArrayList<CountryModel>> = MutableLiveData(ArrayList())
    val countryLoadError = MutableLiveData<Boolean>(false)
    val isLoading = MutableLiveData<Boolean>(true)

    fun refresh(){
        fetchData();
    }

    private fun fetchData() {
        isLoading.value = true
        val countries = arrayListOf<CountryModel>(
            CountryModel("Albania", "Triana", ""),
            CountryModel("Brazil", "Brasilia", ""),
            CountryModel("Bangladesh", "Dhaka", ""),
        )
        countryList.value = countries
        countryLoadError.value = false
        isLoading.value = false
    }
}
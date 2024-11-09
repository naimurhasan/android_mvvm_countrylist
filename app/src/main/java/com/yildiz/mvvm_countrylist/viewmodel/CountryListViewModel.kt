package com.yildiz.mvvm_countrylist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yildiz.mvvm_countrylist.Network.CountryService
import com.yildiz.mvvm_countrylist.model.CountryModel
import kotlinx.coroutines.launch

class CountryListViewModel: ViewModel() {
    val countryList: MutableLiveData<ArrayList<CountryModel>> = MutableLiveData(ArrayList())
    val countryLoadError = MutableLiveData<Boolean>(false)
    val isLoading = MutableLiveData<Boolean>(true)
    private val countryService = CountryService()

    fun refresh(){
        fetchData();
    }

    private fun fetchData() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = countryService.getCountries()
                Log.d("CountryService", "Countries received: ${response.size}")
                countryList.value = response
                countryLoadError.postValue(false)
                isLoading.postValue(false)
            } catch (e: Exception) {
                Log.e("CountryService", "Error fetching countries: ${e.localizedMessage}", e)
                countryLoadError.postValue(true)
                isLoading.postValue(false)
            }
        }
    }


}
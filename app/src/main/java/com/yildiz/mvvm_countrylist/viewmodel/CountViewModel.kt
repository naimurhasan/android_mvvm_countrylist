package com.yildiz.mvvm_countrylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yildiz.mvvm_countrylist.model.CountModel

class CountViewModel: ViewModel() {
    private val _countModel: MutableLiveData<CountModel> = MutableLiveData(CountModel())
    public  val countModel : LiveData<CountModel> get() = _countModel

    fun increment(){
        val currentModel = _countModel.value ?: CountModel() // Provide default if value is null
        currentModel.count += 1
        _countModel.value = currentModel
    }
}
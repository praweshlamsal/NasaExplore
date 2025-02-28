package com.example.nasaexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaexplorer.data.Repository
import com.example.nasaexplorer.data.models.APODModel
import kotlinx.coroutines.launch

class ApodViewModel : ViewModel() {
    private val repository = Repository(NasaApi.retrofitService)
    private val _apodData = MutableLiveData<APODModel>()
    val apodData: LiveData<APODModel> get() = _apodData

    fun fetchApodData(apiKey: String) {
        viewModelScope.launch {
            _apodData.value = repository.getApodData(apiKey)
        }
    }


}
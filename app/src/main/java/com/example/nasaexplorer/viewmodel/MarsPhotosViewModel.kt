package com.example.nasaexplorer.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaexplorer.data.Repository
import com.example.nasaexplorer.data.models.MarsPhoto
import kotlinx.coroutines.launch

class MarsPhotosViewModel : ViewModel() {

    private val repository = Repository(NasaApi.retrofitService)
    private val _marsPhotos = MutableLiveData<List<MarsPhoto>>()
    val marsPhotos: LiveData<List<MarsPhoto>> get() = _marsPhotos

    fun fetchMarsPhotos(earthDate: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.getMarsPhotos(earthDate, apiKey)
                _marsPhotos.value = response.photos
                Log.d("MarsPhotosViewModel", "API response: ${response.photos}")
            } catch (e: Exception) {
                Log.e("MarsPhotosViewModel", "Error fetching Mars photos", e)
            }
        }
    }
}
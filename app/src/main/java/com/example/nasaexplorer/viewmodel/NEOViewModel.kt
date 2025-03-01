package com.example.nasaexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaexplorer.data.Repository
import com.example.nasaexplorer.data.models.NEO
import kotlinx.coroutines.launch

class NEOViewModel : ViewModel() {

    private val repository = Repository(NasaApi.retrofitService) // Initialize Repository

    private val _neoData = MutableLiveData<List<NEO>>()
    val neoData: LiveData<List<NEO>> get() = _neoData

    fun fetchNEOData(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.getNEOData(apiKey)
                // Flatten the map of NEOs into a single list
                val neoList = response.near_earth_objects.flatMap { it.value }
                _neoData.value = neoList
            } catch (e: Exception) {
                // Handle error (e.g., log or show a message)
                _neoData.value = emptyList()
            }
        }
    }
}
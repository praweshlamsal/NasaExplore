package com.example.nasaexplorer.data

import com.example.nasaexplorer.data.models.APODModel

class Repository(private val apiService: ApiService) {
    suspend fun getApodData(apiKey: String): APODModel {
        return apiService.getApodData(apiKey)
    }

    // Add other functions to fetch data for Mars photos, launches, etc.
}
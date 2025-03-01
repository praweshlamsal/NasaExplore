package com.example.nasaexplorer.data

import com.example.nasaexplorer.data.models.APODModel
import com.example.nasaexplorer.data.models.NEOResponse

class Repository(private val apiService: ApiService) {
    suspend fun getApodData(apiKey: String): APODModel {
        return apiService.getApodData(apiKey)
    }

    suspend fun getMarsPhotos(earthDate: String, apiKey: String) = apiService.getMarsPhotos(earthDate, apiKey)

    suspend fun getNEOData(apiKey: String): NEOResponse {
        return apiService.getNEOData(apiKey)
    }
}
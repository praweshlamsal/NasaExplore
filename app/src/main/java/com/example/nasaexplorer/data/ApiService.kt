package com.example.nasaexplorer.data

import com.example.nasaexplorer.data.models.APODModel
import com.example.nasaexplorer.data.models.MarsPhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("planetary/apod")
    suspend fun getApodData(@Query("api_key") apiKey: String): APODModel

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsPhotos(@Query("earth_date") date: String, @Query("api_key") apiKey: String): MarsPhotosResponse

    // Add other endpoints (e.g., Mars Weather, Launches)
}
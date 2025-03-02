package com.example.nasaexplorer.data

import com.example.nasaexplorer.data.models.APODModel
import com.example.nasaexplorer.data.models.MarsPhotosResponse
import com.example.nasaexplorer.data.models.NEOResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("planetary/apod")
    suspend fun getApodData(@Query("api_key") apiKey: String): APODModel

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsPhotos(
        @Query("sol") earthDate: String,
        @Query("api_key") apiKey: String
    ): MarsPhotosResponse

    @GET("neo/rest/v1/feed")
    suspend fun getNEOData(
        @Query("api_key") apiKey: String
    ): NEOResponse
}
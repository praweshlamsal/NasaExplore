package com.example.nasaexplorer.data.models

data class MarsPhotosResponse(
    val photos: List<MarsPhoto>
)

data class MarsPhoto(
    val id: Int,
    val img_src: String,
    val earth_date: String,
    val rover: Rover
)

data class Rover(
    val name: String,
    val landing_date: String,
    val launch_date: String,
    val status: String
)
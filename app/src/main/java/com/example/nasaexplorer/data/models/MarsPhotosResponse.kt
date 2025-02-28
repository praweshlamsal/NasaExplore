package com.example.nasaexplorer.data.models

data class MarsPhotosResponse(
    val photos: List<Photo>
)

data class Photo(
    val id: Int,
    val sol: Int,
    val camera: Camera,
    val img_src: String,
    val earth_date: String
)

data class Camera(
    val id: Int,
    val name: String,
    val rover_id: Int,
    val full_name: String
)

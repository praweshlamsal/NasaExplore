package com.example.nasaexplorer.data.models

data class NEOResponse(
    val near_earth_objects: Map<String, List<NEO>>
)

data class NEO(
    val id: String,
    val name: String,
    val estimated_diameter: EstimatedDiameter,
    val is_potentially_hazardous_asteroid: Boolean,
    val close_approach_data: List<CloseApproachData>
)

data class EstimatedDiameter(
    val kilometers: DiameterRange
)

data class DiameterRange(
    val estimated_diameter_min: Double,
    val estimated_diameter_max: Double
)

data class CloseApproachData(
    val close_approach_date: String,
    val relative_velocity: RelativeVelocity,
    val miss_distance: MissDistance
)

data class RelativeVelocity(
    val kilometers_per_second: String
)

data class MissDistance(
    val kilometers: String
)
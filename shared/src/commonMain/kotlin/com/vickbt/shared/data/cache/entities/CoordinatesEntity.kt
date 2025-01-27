package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "coordinates_table")
data class CoordinatesEntity(
    val lat: Double,
    val lon: Double
)

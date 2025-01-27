package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "city_table")
data class CityEntity(
    val id: Int,
    val name: String,
    val coordinates: CoordinatesEntity,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
)

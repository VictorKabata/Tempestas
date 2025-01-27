package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "weather_table")
data class WeatherEntity(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

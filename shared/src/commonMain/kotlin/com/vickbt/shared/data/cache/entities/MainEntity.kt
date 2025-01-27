package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "main_weather_table")
data class MainEntity(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val groundLevel: Int,
    val humidity: Int,
    val tempKf: Double
)

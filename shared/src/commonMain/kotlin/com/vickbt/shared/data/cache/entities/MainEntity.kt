package com.vickbt.shared.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_weather_table")
data class MainEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int=1,
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

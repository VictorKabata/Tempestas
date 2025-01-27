package com.vickbt.shared.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "main_weather_table")
@Serializable
data class MainEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
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

package com.vickbt.shared.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_weather_table")
data class MainEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int=1,
    val temp: Double?=null,
    val feelsLike: Double?=null,
    val tempMin: Double?=null,
    val tempMax: Double?=null,
    val pressure: Int?=null,
    val seaLevel: Int?=null,
    val groundLevel: Int?=null,
    val humidity: Int?=null,
    val tempKf: Double?=null
)

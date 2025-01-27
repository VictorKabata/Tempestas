package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "weather_data_table")
data class WeatherDataEntity(
    val code: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherItemEntity>,
    val city: CityEntity
)

package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "weather_item_table")
data class WeatherItemEntity(
    val dt: Long,
    val main: MainEntity,
    val weather: List<WeatherEntity>,
    val wind: WindEntity,
    val visibility: Int,
    val pop: Double,
    val dtTxt: String
)

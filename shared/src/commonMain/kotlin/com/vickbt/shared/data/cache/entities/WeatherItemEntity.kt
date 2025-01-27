package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "weather_item_table")
data class WeatherItemEntity(
    val dt: Long?=null,
    val main: MainEntity?=null,
    val weather: List<WeatherEntity>?=null,
    val wind: WindEntity?=null,
    val visibility: Int?=null,
    val pop: Double?=null,
    val dtTxt: String?=null
)

package com.vickbt.shared.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vickbt.shared.data.cache.WeatherTypeConverters

@Entity(tableName = "weather_item_table")
@TypeConverters(WeatherTypeConverters::class)
data class WeatherItemEntity(
    @PrimaryKey(autoGenerate = false)
    val dt: Long? = null,
    @Embedded val main: MainEntity? = null,
    @Embedded val weather: List<WeatherEntity>? = listOf(),
    @Embedded val wind: WindEntity? = null,
    val visibility: Int? = null,
    val pop: Double? = null,
    val dtTxt: String? = null
)

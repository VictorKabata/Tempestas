package com.vickbt.shared.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vickbt.shared.data.cache.convertors.WeatherEntityTypeConverters
import com.vickbt.shared.data.cache.convertors.WeatherItemTypeConverters
import kotlinx.serialization.Serializable

@Entity(tableName = "weather_item_table")
@Serializable
@TypeConverters(WeatherItemTypeConverters::class)
data class WeatherItemEntity(
    @PrimaryKey(autoGenerate = false)
    val dt: Long,
    @Embedded val main: MainEntity,
    @TypeConverters(WeatherEntityTypeConverters::class) val weather: List<WeatherEntity>,
    @Embedded val wind: WindEntity,
    val visibility: Int,
    val pop: Double,
    val dtTxt: String
)

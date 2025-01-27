package com.vickbt.shared.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vickbt.shared.data.cache.convertors.WeatherItemTypeConverters

@Entity(tableName = "weather_data_table")
data class WeatherDataEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
    val code: String,
    val message: Int,
    val cnt: Int,
    @TypeConverters(WeatherItemTypeConverters::class)
    val list: List<WeatherItemEntity>,
    @Embedded val city: CityEntity
)

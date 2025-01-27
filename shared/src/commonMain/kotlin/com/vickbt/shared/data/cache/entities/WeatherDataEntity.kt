package com.vickbt.shared.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_data_table")
data class WeatherDataEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
    val code: String? = null,
    val message: Int? = null,
    val cnt: Int? = null,
    @Embedded val list: List<WeatherItemEntity>? = listOf(),
    @Embedded val city: CityEntity? = null
)

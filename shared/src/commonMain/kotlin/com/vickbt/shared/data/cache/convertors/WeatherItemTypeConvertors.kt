// ktlint-disable filename
package com.vickbt.shared.data.cache.convertors

import androidx.room.TypeConverter
import com.vickbt.shared.data.cache.entities.WeatherItemEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WeatherItemTypeConverters {
    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    @TypeConverter
    fun fromWeatherItemList(data: List<WeatherItemEntity>): String {
        return json.encodeToString(data)
    }

    @TypeConverter
    fun toWeatherItemList(jsonString: String): List<WeatherItemEntity> {
        return json.decodeFromString(jsonString)
    }
}

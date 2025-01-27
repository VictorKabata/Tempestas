package com.vickbt.shared.data.cache.convertors

import androidx.room.TypeConverter
import com.vickbt.shared.data.cache.entities.WeatherEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WeatherEntityTypeConverters {
    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    @TypeConverter
    fun fromWeatherItemList(data: List<WeatherEntity>): String {
        return json.encodeToString(data)
    }

    @TypeConverter
    fun toWeatherItemList(jsonString: String): List<WeatherEntity> {
        return json.decodeFromString(jsonString)
    }
}

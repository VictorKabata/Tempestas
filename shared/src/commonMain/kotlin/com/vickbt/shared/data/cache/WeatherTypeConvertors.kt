package com.vickbt.shared.data.cache

import androidx.room.TypeConverter

class WeatherTypeConverters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",").map { it.trim() }
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }
}

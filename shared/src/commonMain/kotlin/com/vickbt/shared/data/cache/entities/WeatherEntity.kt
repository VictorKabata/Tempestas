package com.vickbt.shared.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "weather_table")
@Serializable
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "weather_id")
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

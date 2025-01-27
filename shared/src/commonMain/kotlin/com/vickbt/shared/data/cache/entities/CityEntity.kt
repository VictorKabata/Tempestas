package com.vickbt.shared.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class CityEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "city_id")
    val cityId: Int,
    val name: String,
    @Embedded
    val coordinates: CoordinatesEntity,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
)

package com.vickbt.shared.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class CityEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "city_id")
    val cityId: Int?=null,
    val name: String?=null,
    @Embedded
    val coordinates: CoordinatesEntity?=null,
    val country: String?=null,
    val population: Int?=null,
    val timezone: Int?=null,
    val sunrise: Long?=null,
    val sunset: Long?=null
)

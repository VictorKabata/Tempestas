package com.vickbt.shared.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coordinates_table")
data class CoordinatesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "coordinates_id")
    val id: Int = 1,
    val lat: Double?=null,
    val lon: Double?=null
)

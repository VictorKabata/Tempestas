package com.vickbt.shared.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wind_table")
data class WindEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "wind_id") val id: Int = 1,
    val speed: Double,
    val deg: Int,
    val gust: Double
)

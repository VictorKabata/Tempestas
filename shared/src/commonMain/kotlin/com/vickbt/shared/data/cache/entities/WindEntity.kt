package com.vickbt.shared.data.cache.entities

import androidx.room.Entity

@Entity(tableName = "wind_table")
data class WindEntity(
    val speed: Double? = null,
    val deg: Int? = null,
    val gust: Double? = null
)

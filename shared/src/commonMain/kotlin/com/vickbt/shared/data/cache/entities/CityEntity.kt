package com.vickbt.shared.data.cache.entities

data class CityEntity(
    val id: Int,
    val name: String,
    val coordinates: CoordinatesEntity,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
)

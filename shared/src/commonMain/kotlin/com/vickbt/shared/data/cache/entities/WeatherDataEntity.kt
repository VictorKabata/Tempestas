package com.vickbt.shared.data.cache.entities

data class WeatherDataEntity(
    val code: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherItemEntity>,
    val city: CityEntity
)

package com.vickbt.shared.data.cache.entities

data class WeatherItemEntity(
    val dt: Long,
    val main: MainEntity,
    val weather: List<WeatherEntity>,
    val wind: WindEntity,
    val visibility: Int,
    val pop: Double,
    val dtTxt: String
)

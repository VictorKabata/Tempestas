package com.vickbt.shared.domain.models

data class WeatherData(
    val code: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherItem>,
    val city: City
)

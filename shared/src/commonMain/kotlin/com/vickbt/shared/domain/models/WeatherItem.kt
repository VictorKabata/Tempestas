package com.vickbt.shared.domain.models

data class WeatherItem(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>,
    val clouds: Clouds? = null,
    val wind: Wind,
    val visibility: Int,
    val pop: Double,
    val rain: Rain? = null,
    val sys: Sys? = null,
    val dtTxt: String
)

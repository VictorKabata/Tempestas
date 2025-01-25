package com.vickbt.domain.models

data class Hourly(
    val dt: Long?,
    val temp: Double?,
    val feelsLike: Double?,
    val pressure: Int?,
    val humidity: Int?,
    val dewPoint: Double?,
    val uvi: Double?,
    val clouds: Int?,
    val visibility: Int?,
    val windSpeed: Double?,
    val windDeg: Int?,
    val windGust: Double?,
    val weather: List<Weather>?,
    val pop: Double?
)
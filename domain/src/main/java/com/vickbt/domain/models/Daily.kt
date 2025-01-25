package com.vickbt.domain.models

data class Daily(
    val dt: Long?,
    val sunrise: Long?,
    val sunset: Long?,
    val moonrise: Long?,
    val moonset: Long?,
    val moonPhase: Double?,
    val summary: String?,
    val temp: Temp?,
    val feelsLike: FeelsLike?,
    val pressure: Int?,
    val humidity: Int?,
    val dewPoint: Double?,
    val windSpeed: Double?,
    val windDeg: Int?,
    val windGust: Double?,
    val weather: List<Weather>?,
    val clouds: Int?,
    val pop: Double?,
    val rain: Double?,
    val uvi: Double?
)
package com.vickbt.domain.models

data class WeatherData(
    val lat: Double?,
    val lon: Double?,
    val timezone: String?,
    val timezoneOffset: Int?,
    val current: Current?,
    val minutely: List<Minutely>?,
    val hourly: List<Hourly>?,
    val daily: List<Daily>?,
    val alerts: List<Alert>?
)
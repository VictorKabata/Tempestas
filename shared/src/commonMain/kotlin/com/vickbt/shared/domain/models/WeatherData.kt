package com.vickbt.shared.domain.models

import kotlinx.datetime.Clock

data class WeatherData(
    val code: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherItem>,
    val city: City,
    val cachedLastAt: Long? = Clock.System.now().toEpochMilliseconds()
)

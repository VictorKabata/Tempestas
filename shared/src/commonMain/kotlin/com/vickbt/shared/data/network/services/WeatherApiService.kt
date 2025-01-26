package com.vickbt.shared.data.network.services

import com.vickbt.shared.data.network.models.WeatherDataDto

interface WeatherApiService {

    /**Return weather forecast for the current users location*/
    suspend fun fetchCurrentLocationWeather(
        query: String,
        vararg exclude: String? = arrayOf("minutely", "hourly", "alerts")
    ): WeatherDataDto

    /**Return weather forecast for the current users location*/
    suspend fun searchLocationWeather(
        latitude: Double,
        longitude: Double,
        vararg exclude: String? = arrayOf("minutely", "hourly", "alerts")
    ): WeatherDataDto
}

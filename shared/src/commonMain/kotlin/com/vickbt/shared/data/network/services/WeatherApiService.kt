package com.vickbt.shared.data.network.services

import com.vickbt.shared.data.network.models.WeatherDataDto
import com.vickbt.shared.domain.utils.MeasurementOptions

interface WeatherApiService {

    /**Return weather forecast for the current users location*/
    suspend fun fetchCurrentLocationWeather(
        query: String,
        units: String = MeasurementOptions.METRIC.name.lowercase(),
        vararg exclude: String? = arrayOf("minutely", "hourly", "alerts")
    ): WeatherDataDto

    /**Return weather forecast for the current users location*/
    suspend fun searchLocationWeather(
        latitude: Double,
        longitude: Double,
        units: String = MeasurementOptions.METRIC.name.lowercase(),
        vararg exclude: String? = arrayOf("minutely", "hourly", "alerts")
    ): WeatherDataDto
}

package com.vickbt.shared.domain.repository

import com.vickbt.shared.domain.models.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    /**Return weather forecast for the current users location*/
    suspend fun fetchCurrentLocationWeather(query: String): Flow<Result<WeatherData>>

    /**Return weather forecast for the current users location*/
    suspend fun searchLocationWeather(
        latitude: Double,
        longitude: Double
    ): Flow<Result<WeatherData>>
}

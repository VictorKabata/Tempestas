package com.vickbt.shared.domain.repository

import com.vickbt.shared.domain.models.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    /**Return weather forecast for the current users location*/
    suspend fun searchLocationWeather(query: String): Flow<Result<WeatherData>>

    /**Return weather forecast for the current users location*/
    suspend fun fetchCurrentLocationWeather(): Flow<Result<WeatherData>>
}

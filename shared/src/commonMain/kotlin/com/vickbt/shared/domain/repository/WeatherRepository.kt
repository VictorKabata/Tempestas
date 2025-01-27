package com.vickbt.shared.domain.repository

import com.vickbt.shared.domain.models.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    /**Return weather forecast for the current users location from network source or local cache*/
    suspend fun fetchCurrentLocationWeather(refresh: Boolean = false): Flow<Result<WeatherData?>>

    /**Return weather forecast for the current users location from network*/
    suspend fun searchLocationWeather(query: String): Flow<Result<WeatherData>>

    /**Get weather data from local cache*/
    suspend fun getWeatherData(): Flow<Result<WeatherData?>>

    /**Save weather data to local cache*/
    suspend fun saveWeatherData(weatherData: WeatherData)
}

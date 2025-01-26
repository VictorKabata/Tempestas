package com.vickbt.shared.data.network.services

interface WeatherApiService {

    suspend fun fetchForecastWeather(
        query: String,
        language: String,
        period: Int = 7
    ): ForecastWeatherDto
}

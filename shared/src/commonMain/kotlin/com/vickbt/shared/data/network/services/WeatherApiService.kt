package com.vickbt.shared.data.network.services

import com.vickbt.shared.data.network.models.ForecastWeatherDto

interface WeatherApiService {

    suspend fun fetchForecastWeather(
        query: String,
        language: String,
        period: Int = 7
    ): ForecastWeatherDto
}

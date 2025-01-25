package com.vickbt.network.services

import com.vickbt.network.dto.ForecastWeatherDto

interface WeatherApiService {

    suspend fun fetchForecastWeather(
        query: String,
        language: String,
        period: Int = 7
    ): ForecastWeatherDto

}

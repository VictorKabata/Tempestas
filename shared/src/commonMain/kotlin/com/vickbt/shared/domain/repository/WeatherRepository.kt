package com.vickbt.shared.domain.repository

import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    /**Return weather forecast for the next 7 days/ 1 week and maps the network response to domain classes*/
    suspend fun fetchForecastWeather(
        query: String? = null,
        language: String = "en",
        period: Int = 7
    ): Flow<Result<ForecastWeather>>
}

package com.vickbt.domain.repositories

import com.vickbt.domain.models.ForecastWeather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun fetchForecastWeather(
        query: String? = null,
        language: String = "en",
        period: Int = 7
    ): Flow<Result<ForecastWeather>>

}

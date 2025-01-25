package com.vickbt.repository.datasources

import com.vickbt.domain.models.ForecastWeather
import com.vickbt.domain.repositories.WeatherRepository
import com.vickbt.domain.utils.Enums.MeasurementOptions
import com.vickbt.network.services.WeatherApiService
import com.vickbt.repository.mappers.toDomain
import com.vickbt.repository.utils.safeApiCall
import kotlinx.coroutines.flow.Flow

class WeatherDataSource(private val weatherApiService: WeatherApiService) : WeatherRepository {

    override suspend fun fetchForecastWeather(
        query: String?,
        language: String,
        period: Int
    ): Flow<Result<ForecastWeather>> {
        val unitOfMeasurement = MeasurementOptions.entries[0]

        return safeApiCall {
            weatherApiService.fetchForecastWeather(
                query = query ?: "Nairobi",
                language = language
            ).toDomain(unitOfMeasurement = unitOfMeasurement)
        }
    }

}

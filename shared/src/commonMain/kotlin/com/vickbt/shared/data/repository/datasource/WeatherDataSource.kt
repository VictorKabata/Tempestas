package com.vickbt.shared.data.repository.datasource

import com.vickbt.shared.data.network.WeatherApiServiceImpl
import com.vickbt.shared.data.network.services.WeatherApiService
import com.vickbt.shared.data.network.utils.safeApiCall
import com.vickbt.shared.data.repository.mappers.toDomain
import com.vickbt.shared.domain.models.ForecastWeather
import com.vickbt.shared.domain.repository.WeatherRepository
import com.vickbt.shared.domain.utils.MeasurementOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import utils.LocationService

class WeatherDataSource(
    private val weatherApiService: WeatherApiService,
    private val locationService: LocationService
) : WeatherRepository {

    override suspend fun fetchForecastWeather(
        query: String?,
        language: String,
        period: Int
    ): Flow<Result<ForecastWeather>> {
        val location = locationService.requestLocationUpdates().firstOrNull()
        val unitOfMeasurement = MeasurementOptions.entries[0]

        return safeApiCall {
            weatherApiService.fetchForecastWeather(
                query = query ?: "${location?.latitude ?: 0.0},${location?.longitude ?: 0.0}",
                language = language,
                period = period
            ).toDomain(unitOfMeasurement = unitOfMeasurement)
        }
    }
}

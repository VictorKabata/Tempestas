package com.vickbt.shared.data.repository.datasource

import com.vickbt.shared.data.network.services.WeatherApiService
import com.vickbt.shared.data.network.utils.safeApiCall
import com.vickbt.shared.data.repository.mappers.toDomain
import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import utils.LocationService

class WeatherDataSource(
    private val weatherApiService: WeatherApiService,
    private val locationService: LocationService
) : WeatherRepository {

    override suspend fun searchLocationWeather(query: String): Flow<Result<WeatherData>> {
        return safeApiCall {
            weatherApiService.fetchCurrentLocationWeather(query = query).toDomain()
        }
    }

    override suspend fun fetchCurrentLocationWeather(): Flow<Result<WeatherData>> {
        val location = locationService.requestLocationUpdates().firstOrNull()

        return safeApiCall {
            weatherApiService.searchLocationWeather(
                latitude = location?.latitude ?: 0.0,
                longitude = location?.longitude ?: 0.0,
            ).toDomain()
        }
    }
}

package com.vickbt.shared.data.repository.datasource

import android.util.Log
import com.vickbt.shared.data.cache.AppDatabase
import com.vickbt.shared.data.network.services.WeatherApiService
import com.vickbt.shared.data.network.utils.safeApiCall
import com.vickbt.shared.data.repository.mappers.toDomain
import com.vickbt.shared.data.repository.mappers.toEntity
import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.repository.WeatherRepository
import com.vickbt.shared.domain.utils.LocationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf

class WeatherDataSource(
    private val weatherApiService: WeatherApiService,
    private val appDatabase: AppDatabase,
    private val locationService: LocationService
) : WeatherRepository {

    override suspend fun fetchCurrentLocationWeather(refresh: Boolean): Flow<Result<WeatherData?>> {
        val cachedResponse = getWeatherData()

        return if (refresh || cachedResponse.firstOrNull()?.getOrNull() == null) {
            val location = locationService.requestLocationUpdates().firstOrNull()

            val networkResponse = safeApiCall {
                weatherApiService.searchLocationWeather(
                    latitude = location?.latitude ?: 0.0,
                    longitude = location?.longitude ?: 0.0,
                ).toDomain()
            }

            networkResponse.firstOrNull()?.onSuccess {
                saveWeatherData(weatherData = it)
            }

            networkResponse
        } else {
            cachedResponse
        }
    }

    override suspend fun searchLocationWeather(query: String): Flow<Result<WeatherData>> {
        return safeApiCall {
            weatherApiService.fetchCurrentLocationWeather(query = query).toDomain()
        }
    }

    override suspend fun getWeatherData(): Flow<Result<WeatherData?>> {
        val cachedData = runCatching {
            appDatabase.weatherDao().getWeatherData()?.firstOrNull()
        }.map { it?.toDomain() }

        Log.e("VicKbt", "Cached time: ${cachedData.getOrNull()?.cachedLastAt}")

        return flowOf(cachedData)
    }

    override suspend fun saveWeatherData(weatherData: WeatherData) {
        runCatching {
            appDatabase.weatherDao().saveWeatherData(weatherData = weatherData.toEntity())
        }
    }
}

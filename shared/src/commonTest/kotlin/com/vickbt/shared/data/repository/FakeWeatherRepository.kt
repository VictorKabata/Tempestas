package com.vickbt.shared.data.repository

import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**Fake implementation of [WeatherRepository] for testing viewModels*/
class FakeWeatherRepository : WeatherRepository {

    var shouldThrowError: Boolean = false
    var weatherData: WeatherData? = null

    override suspend fun fetchCurrentLocationWeather(refresh: Boolean): Flow<Result<WeatherData?>> {
        return if (shouldThrowError) {
            flowOf(Result.failure(Exception("Error occurred!")))
        } else {
            flowOf(Result.success(weatherData))
        }
    }

    override suspend fun searchLocationWeather(query: String): Flow<Result<WeatherData>> {
        return if (shouldThrowError) {
            flowOf(Result.failure(Exception("Error occurred!")))
        } else {
            flowOf(Result.success(weatherData!!))
        }
    }

    override suspend fun getWeatherData(): Flow<Result<WeatherData?>> {
        return if (shouldThrowError) {
            flowOf(Result.failure(Exception("Error occurred!")))
        } else {
            flowOf(Result.success(weatherData!!))
        }
    }

    override suspend fun saveWeatherData(weatherData: WeatherData) {
        this.weatherData = weatherData
    }
}

package com.vickbt.shared.data.network

import com.vickbt.shared.data.network.models.WeatherDataDto
import com.vickbt.shared.data.network.services.WeatherApiService
import com.vickbt.shared.domain.utils.testWeatherDataDto

/**Test fake class for [WeatherApiService] to simulate making network calls via http client*/
class FakeWeatherApiService : WeatherApiService {

    override suspend fun fetchCurrentLocationWeather(
        query: String,
        units: String,
        vararg exclude: String?
    ): WeatherDataDto {
        return testWeatherDataDto
    }

    override suspend fun searchLocationWeather(
        latitude: Double,
        longitude: Double,
        units: String,
        vararg exclude: String?
    ): WeatherDataDto {
        return testWeatherDataDto
    }
}

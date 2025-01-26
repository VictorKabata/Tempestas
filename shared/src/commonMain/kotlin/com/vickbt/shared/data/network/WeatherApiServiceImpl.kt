package com.vickbt.shared.data.network

import com.vickbt.shared.data.network.models.WeatherDataDto
import com.vickbt.shared.data.network.services.WeatherApiService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**Weather API*/
class WeatherApiServiceImpl(private val weatherApiClient: HttpClient) : WeatherApiService {

    override suspend fun fetchCurrentLocationWeather(query: String): WeatherDataDto {
        return weatherApiClient.get("forecast") {
            parameter("q", query)
        }.body<WeatherDataDto>()
    }

    override suspend fun searchLocationWeather(
        latitude: Double,
        longitude: Double
    ): WeatherDataDto {
        return weatherApiClient.get("forecast") {
            parameter("lat", latitude)
            parameter("lon", longitude)
        }.body<WeatherDataDto>()
    }
}

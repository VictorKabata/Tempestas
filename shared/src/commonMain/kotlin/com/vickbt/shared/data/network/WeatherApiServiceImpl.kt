package com.vickbt.shared.data.network

import com.vickbt.shared.data.network.models.ForecastWeatherDto
import com.vickbt.shared.data.network.services.WeatherApiService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**Weather API*/
class WeatherApiServiceImpl(private val weatherApiClient: HttpClient) : WeatherApiService {

    /**Return weather forecast for the next 7 days/ 1 week*/
    override suspend fun fetchForecastWeather(
        query: String,
        language: String
    ): ForecastWeatherDto {
        return weatherApiClient.get("forecast.json") {
            parameter("q", query)
            parameter("lang", language)
            parameter("days", 7)
        }.body<ForecastWeatherDto>()
    }
}

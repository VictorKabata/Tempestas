package com.vickbt.network

import com.vickbt.network.dto.ForecastWeatherDto
import com.vickbt.network.services.WeatherApiService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WeatherApiServiceImpl(private val httpClient: HttpClient) : WeatherApiService {

    override suspend fun fetchForecastWeather(
        query: String,
        language: String,
        period: Int
    ): ForecastWeatherDto {
        return httpClient.get("forecast.json") {
            parameter("q", query)
            parameter("lang", language)
            parameter("days", period)
        }.body<ForecastWeatherDto>()
    }

}

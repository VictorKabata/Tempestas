package com.vickbt.shared.data.network.services

import com.vickbt.shared.data.network.models.WeatherDataDto

interface WeatherApiService {

    /**Return weather forecast for the current users location*/
    suspend fun fetchCurrentLocationWeather(query: String): WeatherDataDto

    /**Return weather forecast for the current users location*/
    suspend fun searchLocationWeather(latitude: Double, longitude: Double): WeatherDataDto
}

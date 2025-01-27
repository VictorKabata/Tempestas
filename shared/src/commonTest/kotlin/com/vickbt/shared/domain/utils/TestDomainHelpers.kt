package com.vickbt.shared.domain.utils

import com.vickbt.shared.domain.models.ApiError
import com.vickbt.shared.domain.models.City
import com.vickbt.shared.domain.models.Clouds
import com.vickbt.shared.domain.models.Coordinates
import com.vickbt.shared.domain.models.Main
import com.vickbt.shared.domain.models.Rain
import com.vickbt.shared.domain.models.Sys
import com.vickbt.shared.domain.models.Weather
import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.models.WeatherItem
import com.vickbt.shared.domain.models.Wind

val testApiError = ApiError(
    code = "400",
    description = "An unknown error occurred"
)

val testCoordinates = Coordinates(
    lat = 0.0,
    lon = 0.0
)

val testCity = City(
    id = 0,
    name = "Nairobi",
    coordinates = testCoordinates,
    country = "KE",
    population = 0,
    timezone = 0,
    sunrise = 0L,
    sunset = 0L
)

val testClouds = Clouds(all = 20)

val testMain = Main(
    temp = 25.0,
    feelsLike = 24.5,
    tempMin = 20.0,
    tempMax = 30.0,
    pressure = 1013,
    seaLevel = 1013,
    groundLevel = 1005,
    humidity = 80,
    tempKf = 1.0
)

val testRain = Rain(threeHourVolume = 11.0)

val testSys = Sys(pod = "d")

val testWeather = Weather(
    id = 800,
    main = "Clear",
    description = "clear sky",
    icon = "01d"
)

val testWind = Wind(
    speed = 5.5,
    deg = 180,
    gust = 7.2
)

val testWeatherItem = WeatherItem(
    dt = 1641013200L,
    main = testMain,
    weather = listOf(testWeather),
    clouds = testClouds,
    wind = testWind,
    visibility = 10000,
    pop = 0.0,
    rain = testRain,
    sys = testSys,
    dtTxt = "2025-01-27 12:00:00"
)

val testWeatherData = WeatherData(
    code = "200",
    message = 0,
    cnt = 0,
    list = listOf(testWeatherItem),
    city = testCity
)

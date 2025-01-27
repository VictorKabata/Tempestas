package com.vickbt.shared.domain.utils

import com.vickbt.shared.data.cache.entities.CityEntity
import com.vickbt.shared.data.cache.entities.CoordinatesEntity
import com.vickbt.shared.data.cache.entities.MainEntity
import com.vickbt.shared.data.cache.entities.WeatherDataEntity
import com.vickbt.shared.data.cache.entities.WeatherEntity
import com.vickbt.shared.data.cache.entities.WeatherItemEntity
import com.vickbt.shared.data.cache.entities.WindEntity

val testCoordinatesEntity = CoordinatesEntity(
    lat = 0.0,
    lon = 0.0
)

val testCityEntity = CityEntity(
    cityId = 0,
    name = "Nairobi",
    coordinates = testCoordinatesEntity,
    country = "KE",
    population = 0,
    timezone = 0,
    sunrise = 0L,
    sunset = 0L
)

val testMainEntity = MainEntity(
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

val testWeatherEntity = WeatherEntity(
    id = 800,
    main = "Clear",
    description = "clear sky",
    icon = "01d"
)

val testWindEntity = WindEntity(
    speed = 5.5,
    deg = 180,
    gust = 7.2
)

val testWeatherItemEntity = WeatherItemEntity(
    dt = 1641013200L,
    main = testMainEntity,
    weather = listOf(testWeatherEntity),
    wind = testWindEntity,
    visibility = 10000,
    pop = 0.0,
    dtTxt = "2025-01-27 12:00:00"
)

val testWeatherDataEntity = WeatherDataEntity(
    code = "200",
    message = 0,
    cnt = 0,
    list = listOf(testWeatherItemEntity),
    city = testCityEntity
)





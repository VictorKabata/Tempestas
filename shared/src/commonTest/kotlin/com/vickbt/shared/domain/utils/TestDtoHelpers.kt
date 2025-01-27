package com.vickbt.shared.domain.utils

import com.vickbt.shared.data.network.models.ApiErrorDto
import com.vickbt.shared.data.network.models.CityDto
import com.vickbt.shared.data.network.models.CloudsDto
import com.vickbt.shared.data.network.models.CoordinatesDto
import com.vickbt.shared.data.network.models.MainDto
import com.vickbt.shared.data.network.models.RainDto
import com.vickbt.shared.data.network.models.SysDto
import com.vickbt.shared.data.network.models.WeatherDataDto
import com.vickbt.shared.data.network.models.WeatherDto
import com.vickbt.shared.data.network.models.WeatherItemDto
import com.vickbt.shared.data.network.models.WindDto

val testApiErrorDto = ApiErrorDto(
    code = "400",
    description = "An unknown error occurred"
)

val testCoordinatesDto = CoordinatesDto(
    lat = 0.0,
    lon = 0.0
)

val testCityDto = CityDto(
    id = 0,
    name = "Nairobi",
    coordinates = testCoordinatesDto,
    country = "KE",
    population = 0,
    timezone = 0,
    sunrise = 0L,
    sunset = 0L
)

val testCloudsDto = CloudsDto(all = 20)

val testMainDto = MainDto(
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

val testRainDto = RainDto(threeHourVolume = 11.0)

val testSysDto = SysDto(pod = "d")

val testWeatherDto = WeatherDto(
    id = 800,
    main = "Clear",
    description = "clear sky",
    icon = "01d"
)

val testWindDto = WindDto(
    speed = 5.5,
    deg = 180,
    gust = 7.2
)

val testWeatherItemDto = WeatherItemDto(
    dt = 1641013200L,
    main = testMainDto,
    weather = listOf(testWeatherDto),
    clouds = testCloudsDto,
    wind = testWindDto,
    visibility = 10000,
    pop = 0.0,
    rain = testRainDto,
    sys = testSysDto,
    dtTxt = "2025-01-27 12:00:00"
)

val testWeatherDataDto = WeatherDataDto(
    code = "200",
    message = 0,
    cnt = 0,
    weatherList = listOf(testWeatherItemDto),
    city = testCityDto
)





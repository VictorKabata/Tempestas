package com.vickbt.shared.data.repository.mappers

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

/**This file contain data transformation functions to convert DTO classes to custom domain classes*/

fun WeatherItemDto.toDomain(): WeatherItem {
    return WeatherItem(
        dt = this.dt,
        main = this.main.toDomain(),
        weather = this.weather.map { it.toDomain() },
        clouds = this.clouds.toDomain(),
        wind = this.wind.toDomain(),
        visibility = this.visibility,
        pop = this.pop,
        rain = this.rain?.toDomain(),
        sys = this.sys.toDomain(),
        dtTxt = this.dtTxt
    )
}

fun MainDto.toDomain(): Main {
    return Main(
        temp = this.temp,
        feelsLike = this.feelsLike,
        tempMin = this.tempMin,
        tempMax = this.tempMax,
        pressure = this.pressure,
        seaLevel = this.seaLevel,
        grndLevel = this.grndLevel,
        humidity = this.humidity,
        tempKf = this.tempKf
    )
}

fun WeatherDto.toDomain(): Weather {
    return Weather(
        id = this.id,
        main = this.main,
        description = this.description,
        icon = this.icon
    )
}

fun CloudsDto.toDomain(): Clouds {
    return Clouds(all = this.all)
}

fun WindDto.toDomain(): Wind {
    return Wind(
        speed = this.speed,
        deg = this.deg,
        gust = this.gust
    )
}

fun RainDto.toDomain(): Rain {
    return Rain(threeHourVolume = this.threeHourVolume)
}

fun SysDto.toDomain(): Sys {
    return Sys(pod = this.pod)
}

fun CityDto.toDomain(): City {
    return City(
        id = this.id,
        name = this.name,
        coordinates = this.coordinates.toDomain(),
        country = this.country,
        population = this.population,
        timezone = this.timezone,
        sunrise = this.sunrise,
        sunset = this.sunset
    )
}

fun CoordinatesDto.toDomain(): Coordinates {
    return Coordinates(
        lat = this.lat,
        lon = this.lon
    )
}

fun WeatherDataDto.toDomain(): WeatherData {
    return WeatherData(
        cod = this.cod,
        message = this.message,
        cnt = this.cnt,
        list = this.weatherList.map { it.toDomain() },
        city = this.city.toDomain()
    )
}

package com.vickbt.shared.data.repository.mappers

import com.vickbt.shared.data.cache.entities.CityEntity
import com.vickbt.shared.data.cache.entities.CoordinatesEntity
import com.vickbt.shared.data.cache.entities.MainEntity
import com.vickbt.shared.data.cache.entities.WeatherDataEntity
import com.vickbt.shared.data.cache.entities.WeatherEntity
import com.vickbt.shared.data.cache.entities.WeatherItemEntity
import com.vickbt.shared.data.cache.entities.WindEntity
import com.vickbt.shared.data.network.models.CityDto
import com.vickbt.shared.data.network.models.CoordinatesDto
import com.vickbt.shared.data.network.models.MainDto
import com.vickbt.shared.data.network.models.WeatherDataDto
import com.vickbt.shared.data.network.models.WeatherDto
import com.vickbt.shared.data.network.models.WeatherItemDto
import com.vickbt.shared.data.network.models.WindDto
import com.vickbt.shared.domain.models.City
import com.vickbt.shared.domain.models.Coordinates
import com.vickbt.shared.domain.models.Weather
import com.vickbt.shared.domain.models.Wind

fun WeatherDataDto.toEntity(): WeatherDataEntity {
    return WeatherDataEntity(
        code = this.code,
        message = this.message,
        cnt = this.cnt,
        list = this.list.map { it.toEntity() },
        city = this.city.toEntity()
    )
}

fun WeatherItemDto.toEntity(): WeatherItemEntity {
    return WeatherItemEntity(
        dt = this.dt,
        main = this.main.toEntity(),
        weather = this.weather.map { it.toEntity() },
        wind = this.wind.toEntity(),
        visibility = this.visibility,
        pop = this.pop,
        dtTxt = this.dtTxt
    )
}

fun MainDto.toEntity(): MainEntity {
    return MainEntity(
        temp = this.temp,
        feelsLike = this.feelsLike,
        tempMin = this.tempMin,
        tempMax = this.tempMax,
        pressure = this.pressure,
        seaLevel = this.seaLevel,
        groundLevel = this.groundLevel,
        humidity = this.humidity,
        tempKf = this.tempKf
    )
}

fun WeatherDto.toEntity(): WeatherEntity {
    return WeatherEntity(
        id = this.id,
        main = this.main,
        description = this.description,
        icon = this.icon
    )
}

fun WindDto.toEntity(): WindEntity {
    return WindEntity(
        speed = this.speed,
        deg = this.deg,
        gust = this.gust
    )
}

fun CityDto.toEntity(): CityEntity {
    return CityEntity(
        id = this.id,
        name = this.name,
        coordinates = this.coordinates.toEntity(),
        country = this.country,
        population = this.population,
        timezone = this.timezone,
        sunrise = this.sunrise,
        sunset = this.sunset
    )
}

fun CoordinatesDto.toEntity(): CoordinatesEntity {
    return CoordinatesEntity(lat = this.lat, lon = this.lon)
}

package com.vickbt.shared.data.repository.mappers

import com.vickbt.shared.data.cache.entities.CityEntity
import com.vickbt.shared.data.cache.entities.CoordinatesEntity
import com.vickbt.shared.data.cache.entities.MainEntity
import com.vickbt.shared.data.cache.entities.WeatherDataEntity
import com.vickbt.shared.data.cache.entities.WeatherEntity
import com.vickbt.shared.data.cache.entities.WeatherItemEntity
import com.vickbt.shared.data.cache.entities.WindEntity
import com.vickbt.shared.domain.models.City
import com.vickbt.shared.domain.models.Coordinates
import com.vickbt.shared.domain.models.Main
import com.vickbt.shared.domain.models.Weather
import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.models.WeatherItem
import com.vickbt.shared.domain.models.Wind

fun WeatherDataEntity.toDomain(): WeatherData {
    return WeatherData(
        code = this.code,
        message = this.message,
        cnt = this.cnt,
        list = this.list.map { it.toDomain() },
        city = this.city.toDomain()
    )
}

fun WeatherItemEntity.toDomain(): WeatherItem {
    return WeatherItem(
        dt = this.dt,
        main = this.main.toDomain(),
        weather = this.weather.map { it.toDomain() },
        wind = this.wind.toDomain(),
        visibility = this.visibility,
        pop = this.pop,
        dtTxt = this.dtTxt
    )
}

fun MainEntity.toDomain(): Main {
    return Main(
        temp = this.temp,
        feelsLike = this.feelsLike,
        tempMin = this.tempMin,
        tempMax = this.tempMax,
        pressure = this.pressure,
        seaLevel = this.seaLevel,
        groundLevel = this.grndLevel,
        humidity = this.humidity,
        tempKf = this.tempKf
    )
}

fun WeatherEntity.toDomain(): Weather {
    return Weather(
        id = this.id,
        main = this.main,
        description = this.description,
        icon = this.icon
    )
}

fun WindEntity.toDomain(): Wind {
    return Wind(
        speed = this.speed,
        deg = this.deg,
        gust = this.gust
    )
}

fun CityEntity.toDomain(): City {
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

fun CoordinatesEntity.toDomain(): Coordinates {
    return Coordinates(lat = this.lat, lon = this.lon)
}

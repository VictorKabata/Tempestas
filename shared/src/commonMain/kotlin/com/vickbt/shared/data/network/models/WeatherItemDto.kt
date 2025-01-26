package com.vickbt.shared.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherItemDto(
    @SerialName("dt") val dt: Long,
    @SerialName("main") val main: MainDto,
    @SerialName("weather") val weather: List<WeatherDto>,
    @SerialName("clouds") val clouds: CloudsDto,
    @SerialName("wind") val wind: WindDto,
    @SerialName("visibility") val visibility: Int,
    @SerialName("pop") val pop: Double,
    @SerialName("rain") val rain: RainDto?,
    @SerialName("sys") val sys: SysDto,
    @SerialName("dt_txt") val dtTxt: String
)

package com.vickbt.shared.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataDto(
    @SerialName("cod") val code: String,
    @SerialName("message") val message: Int,
    @SerialName("cnt") val cnt: Int,
    @SerialName("list") val weatherList: List<WeatherItemDto>,
    @SerialName("city") val city: CityDto
)

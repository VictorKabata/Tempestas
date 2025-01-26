package com.vickbt.shared.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("coord") val coordinates: CoordinatesDto,
    @SerialName("country") val country: String,
    @SerialName("population") val population: Int,
    @SerialName("timezone") val timezone: Int,
    @SerialName("sunrise") val sunrise: Long,
    @SerialName("sunset") val sunset: Long
)

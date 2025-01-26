package com.vickbt.shared.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesDto(
    @SerialName("lat") val lat: Double,
    @SerialName("lon") val lon: Double
)

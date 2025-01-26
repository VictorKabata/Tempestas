package com.vickbt.shared.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RainDto(
    @SerialName("3h") val threeHourVolume: Double
)

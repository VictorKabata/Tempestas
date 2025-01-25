package com.vickbt.network.dto

import com.vickbt.network.dto.ForecastDayDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDto(
    @SerialName("forecastday")
    val forecastday: List<ForecastDayDto>
)

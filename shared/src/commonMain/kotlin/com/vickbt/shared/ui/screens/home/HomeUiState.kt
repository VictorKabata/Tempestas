// ktlint-disable filename

package com.vickbt.shared.ui.screens.home

import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.models.WeatherItem

data class HomeUiStates(
    val isLoading: Boolean = true,
    val error: String? = null,
    val currentLocationWeather: WeatherData? = null,
    val currentLocationWeatherForecast: List<WeatherItem>? = emptyList()
)

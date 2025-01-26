// ktlint-disable filename

package com.vickbt.shared.ui.screens.search

import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.models.WeatherItem

data class SearchUiStates(
    val isLoading: Boolean = true,
    val error: String? = null,
    val searchedLocationWeather: WeatherData? = null,
    val searchedLocationWeatherForecast: List<WeatherItem>? = emptyList()
)

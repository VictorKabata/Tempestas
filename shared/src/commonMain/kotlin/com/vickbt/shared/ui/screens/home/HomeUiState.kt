// ktlint-disable filename

package com.vickbt.shared.ui.screens.home

import com.vickbt.shared.domain.models.WeatherData

data class HomeUiStates(
    val isLoading: Boolean = true,
    val error: String? = null,
    val currentLocationWeather: WeatherData? = null,
    val searchedLocationWeather: WeatherData? = null
)

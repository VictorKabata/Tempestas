// ktlint-disable filename

package com.vickbt.shared.ui.screens.home

data class HomeUiStates(
    val isLoading: Boolean = true,
    val error: String? = null,
    val forecastWeather: ForecastWeather? = null
)

package com.vickbt.shared.ui.states

data class WeatherUiState<T, U>(
    val isLoading: Boolean = true,
    val error: String? = null,
    val locationCurrentWeather: T? = null,
    val locationWeatherForecast: U? = null
)

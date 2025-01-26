package com.vickbt.shared.ui.screens.home

import com.vickbt.shared.domain.models.ForecastWeather

data class HomeUiStates(
    val isLoading: Boolean = true,
    val error: String? = null,
    val forecastWeather: ForecastWeather? = null,
)
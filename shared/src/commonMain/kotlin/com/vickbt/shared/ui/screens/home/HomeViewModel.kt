package com.vickbt.shared.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.models.WeatherItem
import com.vickbt.shared.domain.repository.WeatherRepository
import com.vickbt.shared.ui.states.WeatherUiState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _homeUiState =
        MutableStateFlow(WeatherUiState<WeatherData, List<WeatherItem>>(isLoading = true))
    val homeUiState = _homeUiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _homeUiState.update { it.copy(isLoading = false, error = exception.message) }
    }

    init {
        fetchCurrentLocationWeather()
    }

    fun fetchCurrentLocationWeather(refresh: Boolean = false) =
        viewModelScope.launch(coroutineExceptionHandler) {
            val currentDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date.toString()

            weatherRepository.fetchCurrentLocationWeather(refresh = refresh)
                .collectLatest { result ->
                    result.onSuccess { weatherData ->
                        val weatherForecast =
                            weatherData?.list?.filterNot { it.dtTxt.contains(currentDate) }
                                ?.groupBy { it.dtTxt.substringBefore(" ") }
                                ?.map { it.value.first() }

                        _homeUiState.update {
                            it.copy(
                                isLoading = false,
                                locationCurrentWeather = weatherData,
                                locationWeatherForecast = weatherForecast
                            )
                        }
                    }.onFailure {
                        _homeUiState.update { it.copy(isLoading = false, error = it.error) }
                    }
                }
        }
}

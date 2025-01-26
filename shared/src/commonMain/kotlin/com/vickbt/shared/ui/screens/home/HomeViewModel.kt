package com.vickbt.shared.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickbt.shared.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val homeUiStateFlow = MutableStateFlow(HomeUiStates(isLoading = true))
    val homeUiState = homeUiStateFlow.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        homeUiStateFlow.update { it.copy(isLoading = false, error = exception.message) }
    }

    init {
        fetchCurrentLocationWeather()
    }

    fun fetchCurrentLocationWeather() =
        viewModelScope.launch(coroutineExceptionHandler) {
            val currentDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date.toString()

            weatherRepository.fetchCurrentLocationWeather().collect { result ->
                result.onSuccess { weatherData ->
                    val weatherForecast =
                        weatherData.list.filterNot { it.dtTxt.contains(currentDate) }
                            .groupBy { it.dtTxt.substringBefore(" ") }
                            .map { it.value.first() }

                    homeUiStateFlow.update {
                        it.copy(
                            isLoading = false,
                            currentLocationWeather = weatherData,
                            currentLocationWeatherForecast = weatherForecast
                        )
                    }
                }.onFailure {
                    homeUiStateFlow.update { it.copy(isLoading = false, error = it.error) }
                }
            }
        }

    /*fun searchLocationWeather(query: String) =
        viewModelScope.launch(coroutineExceptionHandler) {
            weatherRepository.searchLocationWeather(query = query).collect { result ->
                result.onSuccess { weatherData ->
                    homeUiStateFlow.update {
                        it.copy(isLoading = false, searchedLocationWeather = weatherData)
                    }
                }.onFailure {
                    homeUiStateFlow.update { it.copy(isLoading = false, error = it.error) }
                }
            }
        }*/
}

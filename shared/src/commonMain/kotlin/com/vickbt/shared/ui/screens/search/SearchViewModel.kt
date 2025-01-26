package com.vickbt.shared.ui.screens.search

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

class SearchViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _searchUiState = MutableStateFlow(SearchUiStates(isLoading = true))
    val searchUiState = _searchUiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _searchUiState.update { it.copy(isLoading = false, error = exception.message) }
    }

    fun searchLocationWeather(query: String) =
        viewModelScope.launch(coroutineExceptionHandler) {
            val currentDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date.toString()

            weatherRepository.searchLocationWeather(query = query).collect { result ->
                result.onSuccess { weatherData ->
                    val weatherForecast =
                        weatherData.list.filterNot { it.dtTxt.contains(currentDate) }
                            .groupBy { it.dtTxt.substringBefore(" ") }
                            .map { it.value.first() }

                    _searchUiState.update {
                        it.copy(
                            isLoading = false,
                            searchedLocationWeather = weatherData,
                            searchedLocationWeatherForecast = weatherForecast
                        )
                    }
                }.onFailure {
                    _searchUiState.update { it.copy(isLoading = false, error = it.error) }
                }
            }
        }
}

package com.vickbt.shared.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickbt.shared.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val homeUiStateFlow = MutableStateFlow(HomeUiStates(isLoading = true))
    val homeUiState = homeUiStateFlow.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        homeUiStateFlow.update { it.copy(isLoading = false, error = exception.message) }
    }

    init {
        fetchForecastWeather()
    }

    fun fetchForecastWeather(query: String? = null) =
        viewModelScope.launch(coroutineExceptionHandler) {
            weatherRepository.fetchForecastWeather(query = query).collect { result ->
                result.onSuccess { forecastWeather ->
                    homeUiStateFlow.update {
                        it.copy(isLoading = false, forecastWeather = forecastWeather)
                    }
                }.onFailure {
                    homeUiStateFlow.update { it.copy(isLoading = false, error = it.error) }
                }
            }
        }

}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.vickbt.shared.ui.screens.search

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vickbt.shared.ui.components.ItemWeatherData
import com.vickbt.shared.ui.components.SearchAppBar
import org.koin.compose.koinInject

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: SearchViewModel = koinInject()
) {
    var searchQuery by remember { mutableStateOf<String?>(null) }

    val searchUiState by viewModel.searchUiState.collectAsState()
    val scrollState = rememberScrollState()

    Log.e("VicKbt", "search ui state current city: ${searchUiState.locationCurrentWeather?.city}")
    Log.e("VicKbt", "search ui state forecast: ${searchUiState.locationWeatherForecast}")

    LaunchedEffect(searchQuery) {
        searchQuery?.let { viewModel.searchLocationWeather(query = it) }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.padding(paddingValues),
            topBar = {
                SearchAppBar(
                    modifier = Modifier,
                    onSearch = { searchQuery = it },
                    onBackClick = { navController.navigateUp() }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                if (searchUiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .testTag("loading_progress_bar")
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                } else if (searchUiState.error != null) {
                    Text(
                        modifier = Modifier
                            .testTag("error_text")
                            .align(Alignment.Center)
                            .wrapContentSize()
                            .padding(horizontal = 24.dp),
                        text = searchUiState.error ?: "Error",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                } else {
                    ItemWeatherData(
                        modifier = Modifier.testTag("weather_info_column")
                            .fillMaxSize()
                            .verticalScroll(scrollState),
                        weatherData = searchUiState,
                    )
                }
            }
        }
    }
}

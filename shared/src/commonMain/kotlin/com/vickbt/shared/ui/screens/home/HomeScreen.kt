@file:OptIn(ExperimentalMaterial3Api::class)

package com.vickbt.shared.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vickbt.shared.ui.components.ItemWeatherData
import com.vickbt.shared.ui.navigation.NavigationItem
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: HomeViewModel = koinInject()
) {
    val homeUiState = viewModel.homeUiState.collectAsState().value
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        if (homeUiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .testTag("loading_progress_bar")
                    .align(Alignment.Center)
            )
        } else if (homeUiState.locationCurrentWeather != null && homeUiState.locationWeatherForecast != null) {
            Scaffold(
                modifier = Modifier.padding(paddingValues),
                topBar = {
                    TopAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        title = { },
                        actions = {
                            Row {
                                IconButton(
                                    onClick = { navController.navigate(NavigationItem.Search.route) },
                                    modifier = Modifier.padding(horizontal = 16.dp),
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Search,
                                        contentDescription = "Menu",
                                    )
                                }
                            }
                        }
                    )
                }
            ) { innerPadding ->
                ItemWeatherData(
                    modifier = Modifier.testTag("weather_info_column")
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(scrollState),
                    weatherData = homeUiState
                )
            }
        } else if (homeUiState.error != null) {
            Text(
                modifier = Modifier
                    .testTag("error_text")
                    .align(Alignment.Center)
                    .padding(horizontal = 24.dp),
                text = homeUiState.error,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

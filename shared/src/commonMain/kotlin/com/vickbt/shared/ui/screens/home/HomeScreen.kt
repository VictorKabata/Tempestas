@file:OptIn(ExperimentalMaterial3Api::class)

package com.vickbt.shared.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vickbt.shared.ui.components.ItemWeatherData
import com.vickbt.shared.ui.navigation.NavigationItem
import dev.materii.pullrefresh.PullRefreshLayout
import dev.materii.pullrefresh.rememberPullRefreshState
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: HomeViewModel = koinInject()
) {
    val homeUiState by viewModel.homeUiState.collectAsState()
    val scrollState = rememberScrollState()

    var isRefreshing by remember { mutableStateOf(false) }
    val pullRefreshState =
        rememberPullRefreshState(refreshing = isRefreshing, onRefresh = { isRefreshing = true })

    LaunchedEffect(isRefreshing) {
        viewModel.fetchCurrentLocationWeather(refresh = isRefreshing)
        isRefreshing = false
    }

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
                        modifier = Modifier.fillMaxWidth().height(52.dp),
                        title = { },
                        actions = {
                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(
                                    modifier = Modifier.size(48.dp).clip(CircleShape),
                                    onClick = { navController.navigate(NavigationItem.Search.route) },
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Search,
                                        contentDescription = "Search",
                                    )
                                }
                            }
                        }
                    )
                }
            ) { innerPadding ->
                PullRefreshLayout(
                    modifier = Modifier.testTag("pull_refresh").fillMaxSize(),
                    state = pullRefreshState
                ) {
                    ItemWeatherData(
                        modifier = Modifier.testTag("weather_info_column")
                            .fillMaxSize()
                            .padding(innerPadding)
                            .verticalScroll(scrollState),
                        weatherData = homeUiState
                    )
                }
            }
        } else if (homeUiState.error != null) {
            Text(
                modifier = Modifier
                    .testTag("error_text")
                    .align(Alignment.Center)
                    .padding(horizontal = 24.dp),
                text = homeUiState.error ?: "Error",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

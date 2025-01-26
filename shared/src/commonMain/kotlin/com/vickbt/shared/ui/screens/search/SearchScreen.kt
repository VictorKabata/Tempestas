package com.vickbt.shared.ui.screens.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.compose.koinInject

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: SearchViewModel = koinInject()
) {
}

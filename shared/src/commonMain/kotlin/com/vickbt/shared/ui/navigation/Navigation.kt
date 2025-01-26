package com.vickbt.shared.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vickbt.shared.ui.screens.home.HomeScreen
import com.vickbt.shared.ui.screens.search.SearchScreen

@Composable
fun Navigation(paddingValues: PaddingValues) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen(paddingValues = paddingValues, navController = navController)
        }

        composable(route = NavigationItem.Search.route) {
            SearchScreen(paddingValues = paddingValues, navController = navController)
        }
    }
}

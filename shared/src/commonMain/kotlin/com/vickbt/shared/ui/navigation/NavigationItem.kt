package com.vickbt.shared.ui.navigation

sealed class NavigationItem(val route: String, val title: String) {
    data object Home : NavigationItem(route = "home", title = "Home")
    data object Search : NavigationItem(route = "search", title = "Search")
}

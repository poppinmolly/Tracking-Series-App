package com.example.trackingwatchactivity.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trackingwatchactivity.presentation.screens.discoverScreen.DiscoverScreen
import com.example.trackingwatchactivity.presentation.screens.discoverScreen.DiscoverScreenUi
import com.example.trackingwatchactivity.presentation.screens.libraryScreen.LibraryScreen
import com.example.trackingwatchactivity.presentation.screens.profileScreen.ProfileScreen
import com.example.trackingwatchactivity.presentation.screens.statsScreen.StatsScreen


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
){
    NavHost(
        navController = navController,
        startDestination = Routes.DiscoverScreen.route,
        modifier = modifier
    ) {
        composable(Routes.DiscoverScreen.route){ DiscoverScreen()}
        composable(Routes.LibraryScreen.route){ LibraryScreen() }
        composable(Routes.StatsScreen.route){ StatsScreen() }
        composable(Routes.ProfileScreen.route){ ProfileScreen() }
    }
}
package com.example.trackingwatchactivity.presentation.navigation

sealed class Routes(val route: String){
    object DiscoverScreen: Routes("discover")
    object LibraryScreen: Routes("library")
    object StatsScreen: Routes("stats")
    object ProfileScreen: Routes("profile")
}
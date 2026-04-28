package com.example.trackingwatchactivity.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.trackingwatchactivity.presentation.navigation.AppNavHost
import com.example.trackingwatchactivity.presentation.screens.discoverScreen.DiscoverScreenUi
import com.example.trackingwatchactivity.presentation.theme.BackgroundGradient
import com.example.trackingwatchactivity.presentation.utils.BottomNavBar
import com.example.trackingwatchactivity.presentation.utils.TopBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = BackgroundGradient)
            ){
                Scaffold(
                    containerColor = Color.Transparent,
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar(title = "Discover", modifier = Modifier.fillMaxWidth().statusBarsPadding()) },
                    bottomBar = { BottomNavBar(navController = navController) }
                ) { innerPadding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
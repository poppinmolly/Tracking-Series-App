package com.example.trackingwatchactivity.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.presentation.navigation.NavigationItem
import com.example.trackingwatchactivity.presentation.theme.BottomBarBackground
import com.example.trackingwatchactivity.presentation.theme.GrayMainAppColor
import com.example.trackingwatchactivity.presentation.theme.PurpleMainAppColor

val navigationItems = listOf(
    NavigationItem(
        title = "Discover",
        ico = R.drawable.ic_home,
        route = "discover"
    ),
    NavigationItem(
        title = "Library",
        ico = R.drawable.ic_movie,
        route = "library"
    ),
    NavigationItem(
        title = "Stats",
        ico = R.drawable.ic_stats,
        route = "stats"
    ),
    NavigationItem(
        title = "Profile",
        ico = R.drawable.ic_profile,
        route = "profile"
    ),
)


@Composable
fun BottomNavBar(
    navController: NavController
){
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar(
        containerColor = BottomBarBackground
    ){
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { IconOfBottomBar(
                    icon = item.ico,
                    description = item.title,
                )},
                label = { Text(text = item.title) },
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route) },
                colors = NavigationBarItemColors(
                    selectedIconColor = PurpleMainAppColor,
                    selectedTextColor = PurpleMainAppColor,
                    selectedIndicatorColor = PurpleMainAppColor.copy(0.3f),
                    unselectedIconColor = GrayMainAppColor,
                    unselectedTextColor = GrayMainAppColor,
                    disabledIconColor = GrayMainAppColor,
                    disabledTextColor = GrayMainAppColor,
                )
            )
        }
    }
}


@Composable
private fun IconOfBottomBar(
    icon: Int,
    description: String,
){
    Icon(
        painter = painterResource(icon),
        contentDescription = description,
        modifier = Modifier.size(25.dp),
    )
}




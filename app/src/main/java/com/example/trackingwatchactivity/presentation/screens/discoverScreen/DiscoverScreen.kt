package com.example.trackingwatchactivity.presentation.screens.discoverScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.presentation.theme.BottomBarBackground
import com.example.trackingwatchactivity.presentation.theme.GrayMainAppColor
import com.example.trackingwatchactivity.presentation.theme.PurpleMainAppColor
import com.example.trackingwatchactivity.presentation.utils.CardWithFilm
import com.example.trackingwatchactivity.presentation.utils.InformationCard


data class MoviesTest(
    val nameOfTitle: String = "Breaking Bad",
    val ico: Int = R.drawable.bannerbreakingbadtest,
    val year: String = "2008",

    val rating: String = "9.5"
)

val films = listOf(
    MoviesTest(),  MoviesTest(), MoviesTest(), MoviesTest(), MoviesTest(), MoviesTest(), MoviesTest(),
)

@Composable
fun DiscoverScreenUi(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        InformationCard(
            modifier = Modifier
                .fillMaxWidth(0.93f)
                .height(100.dp),
            titleText = "Track Your Progress",
            descriptionText = "Tap any show to mark episodes as watched and track your progress through seasons!",
            ico = R.drawable.ic_tv
        )


        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        InputBar()
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        CategoryText(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 10.dp, vertical = 6.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {
            items(films){
                films ->
                CardWithFilm(film = films)

            }
        }
    }
}

@Preview
@Composable
fun InputBar(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ){
        TextField(
            modifier = Modifier.fillMaxWidth(0.95f),
            label = {
                Text(
                    text = "Search movies and series...",
                    color = Color.Gray
                )
                    },
            value = "",
            onValueChange = {},
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2B2930),
                unfocusedContainerColor = BottomBarBackground,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLeadingIconColor = PurpleMainAppColor,
                unfocusedLeadingIconColor = BottomBarBackground,
                focusedPlaceholderColor = PurpleMainAppColor,
                unfocusedPlaceholderColor = BottomBarBackground,
                cursorColor = PurpleMainAppColor,
            ),
            leadingIcon = {
                Icon(painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = GrayMainAppColor,
                    )
            }

        )
    }
}

@Composable
private fun CategoryText(
    modifier: Modifier
){
    Text(text = "Trending Now",
        color = GrayMainAppColor,
        modifier = modifier,
        fontSize = 17.sp
    )
}
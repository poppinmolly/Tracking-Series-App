package com.example.trackingwatchactivity.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.presentation.screens.discoverScreen.MoviesTest
import com.example.trackingwatchactivity.presentation.theme.GrayMainAppColor


@Composable
fun CardWithFilm(
    modifier: Modifier = Modifier,
    film: MoviesTest
){
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Box(
            modifier = modifier
                .width(150.dp)
                .height(180.dp),
            contentAlignment = Alignment.Center

        ){
            Image(
                painter = painterResource(film.ico),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))

            )
            RatingElement(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(horizontal = 17.dp, vertical = 5.dp),
                ratingText = film.rating


            )

        }
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(text = film.nameOfTitle,
                fontSize = 15.sp,
                color = GrayMainAppColor)
            Text(text = film.year,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = GrayMainAppColor
            )
        }
    }
}

@Composable
fun RatingElement(
    modifier: Modifier = Modifier,
    ratingText: String,
){
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .height(30.dp)
            .width(50.dp)
            .background(Color.Black.copy(0.95f)),
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.padding(horizontal = 1.dp))
            Text(text = ratingText,
                fontSize = 15.sp,
                color = Color.White)
        }
    }
}
@Preview
@Composable
fun RatingElementPreview(){
    RatingElement(ratingText = "9.5")
}

val test: MoviesTest = MoviesTest()
@Composable
@Preview(showBackground = true)
fun CardWithFilmPreview(){
    CardWithFilm(
        film = test
    )
}
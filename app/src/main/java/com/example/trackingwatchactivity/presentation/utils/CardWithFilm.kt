package com.example.trackingwatchactivity.presentation.utils

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import coil3.compose.AsyncImage
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.domain.model.ShowModel
import com.example.trackingwatchactivity.presentation.theme.GrayMainAppColor
import kotlin.Int


@Composable
fun CardWithFilm(
    modifier: Modifier = Modifier,
    film: ShowModel
){
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Box(
            modifier = modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .width(150.dp)
                .height(180.dp),
            contentAlignment = Alignment.Center

        ){
            ImagePoster(url = film.posterPath)
            RatingElement(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(horizontal = 17.dp, vertical = 5.dp),
                ratingText = film.voteAverage
            )

        }
        Column() {
            Text(text = film.name,
                fontSize = 15.sp,
                color = GrayMainAppColor)
            Text(text = film.date,
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
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
private fun RatingElementPreview(){
    RatingElement(ratingText = "9.5")
}

private val testFilm = ShowModel(
    id = 1,
    name = "Test Title",
    overview = "Something text test",
    genreIds = listOf(1,2,3,4),
    voteAverage = "5.5",
    posterPath = "https://image.tmdb.org/t/p/w500/5lcxWLVAEICkFpuAiV1aMy7ZZj3.jpg",
    date = "2005",
    title = "Test title again!"
)


@Composable
private fun CardWithFilmPreview(){
    CardWithFilm(film = testFilm)
}

@Composable
fun ImagePoster(
    url: String
){
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
    )
    Log.d("ImagePoster", "url: $url")
}
package com.example.trackingwatchactivity.presentation.screens.detailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.domain.model.WatchStatus
import com.example.trackingwatchactivity.presentation.theme.BottomBarBackground
import com.example.trackingwatchactivity.presentation.theme.GrayMainAppColor
import com.example.trackingwatchactivity.presentation.theme.PurpleMainAppColor

@Preview
@Composable
fun DetailScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ){

            // BANNER
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(R.drawable.moviebannertest),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            // darkening at the bottom
            ImageWrapper()

            // TITLE OF FILM & YEAR & RATING & DURATION
            FilmInformation()

        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        // STATUS OF WATCHING
        RowOfButtonsStatus()
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        // AdditionalButtons (RATE | ADD NOTE | DELETE)
        AdditionalButtons(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}


@Composable
fun FilmInformation(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ){
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Inception",
                fontSize = 25.sp,
                color = Color.White
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "2010",
                    color = GrayMainAppColor
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = Color.Unspecified
                    )

                    Text(
                        "8.8",
                        color = GrayMainAppColor
                    )
                }
                Text(
                    "148 min",
                    color = GrayMainAppColor
                )
            }
        }
    }
}

@Composable
fun ImageWrapper(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.1f),
                        Color.Black.copy(alpha = 0.9f)
                    )
                )
            )
    )
}

@Composable
fun ButtonOfFilmStatus(
    status: String
){
    Button(
        onClick = {},
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 5.dp)
        ,
        colors = ButtonColors(
            containerColor = PurpleMainAppColor,
            contentColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified
        )
    ) {
        Text(
            text = status,
            color = BottomBarBackground
            )
    }
}

@Composable
fun RowOfButtonsStatus(){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 5.dp)
    ) {
        items(WatchStatus.entries){
            item ->
            ButtonOfFilmStatus(item.title)
        }
    }
}

@Composable
fun AdditionalButtons(
    modifier: Modifier = Modifier
){
    Row(modifier = modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // RATE BUTTON
        Button(
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(45.dp)
                .width(150.dp),
            colors = ButtonColors(
                containerColor = BottomBarBackground,
                contentColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            )
        ) {
            Text(
                text = "Rate",
                color = GrayMainAppColor,
                fontSize = 16.sp
            )
        }
        // ADD NOTES BUTTON
        Button(
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(45.dp)
                .width(150.dp)
                .padding(horizontal = 10.dp),
            colors = ButtonColors(
                containerColor = BottomBarBackground,
                contentColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            )
        ) {
            Text(
                text = "Add Notes",
                color = GrayMainAppColor,
                fontSize = 16.sp
            )
        }
        // DELETE BUTTON
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(13.dp))
                .background(Color(0xFF332A2D))
                .size(height = 45.dp, width = 50.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = "Trash Button",
                modifier = Modifier.size(20.dp),
                tint = Color(0xFFFFB4AA),
            )
        }
    }
}

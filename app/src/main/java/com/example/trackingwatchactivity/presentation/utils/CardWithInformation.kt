package com.example.trackingwatchactivity.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.presentation.theme.BackgroundCardGradient
import com.example.trackingwatchactivity.presentation.theme.BorderGradientOfCard


@Composable
fun InformationCard(
    modifier: Modifier = Modifier,
    titleText: String,
    descriptionText: String,
    ico: Int,

    ){
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxSize()
            .background(brush = BackgroundCardGradient)
            .border(
                brush = BorderGradientOfCard,
                width = 1.dp,
                shape = RoundedCornerShape(16.dp))

    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(ico),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = titleText, fontSize = 15.sp, color = Color.White)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = descriptionText, fontSize = 12.sp, color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun InformationCardPreview(){
    InformationCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        titleText = "Track Your Progress",
        descriptionText = "Tap any show to mark episodes as watched and track your progress through seasons!",
        ico = R.drawable.ic_tv
    )
}
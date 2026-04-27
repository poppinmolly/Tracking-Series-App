package com.example.trackingwatchactivity.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingwatchactivity.R
import com.example.trackingwatchactivity.presentation.theme.GrayMainAppColor


@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
){
    Column() {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title,
                color = GrayMainAppColor,
                fontSize = 20.sp,

                )
            Icon(
                painter = painterResource(R.drawable.ic_sun),
                contentDescription = null,
                tint = GrayMainAppColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        HorizontalDivider(color = GrayMainAppColor)
    }
}
@Preview
@Composable
private fun TopBarPreview(){
    TopBar(
        title = "Discover"
    )
}
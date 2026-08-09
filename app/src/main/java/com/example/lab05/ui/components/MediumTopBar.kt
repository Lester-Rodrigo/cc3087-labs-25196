package com.example.lab05.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05.model.TopBar

@Composable
fun MediumTopBar(
    topBar: TopBar,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .background(Color.Red) ,
            contentAlignment = Alignment.Center
        ){
            Text(
                text = topBar.logo,
                fontSize = 20.sp
            )
        }
        Text(
            text = topBar.title,
            fontSize = 30.sp
            )
        Text(
            text = topBar.extraText,
            fontSize = 30.sp
            )
    }
}

@Preview(showBackground = true)
@Composable
fun MediumTopBarPreview(
    modifier: Modifier = Modifier
) {
    val title = "P"
    val logo = "GH"
    val extraText = "CGYFIUGYF"
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
                .background(Color.Red)
        ){
            Text(logo)
        }
        Text(title)
        Text(extraText)
    }
}
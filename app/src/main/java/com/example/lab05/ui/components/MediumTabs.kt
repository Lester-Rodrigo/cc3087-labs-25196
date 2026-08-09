package com.example.lab05.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05.model.Tabs

@Composable
fun MediumTabs(
    tabs: Tabs,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = tabs.option1,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Text(
            text = tabs.option2,
            fontSize = 17.sp
        )
        Text(
            text = tabs.option3,
            fontSize = 17.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MediumTabs(
) {
    val option1 = "Para ti"
    val option2 = "Promociones"
    val option3 = "Temporada"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = option1,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = option2
        )
        Text(
            text = option3
        )
    }
}
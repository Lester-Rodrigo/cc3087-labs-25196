package com.example.lab05.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MediumTabs(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf(
        "Para ti",
        "Siguiendo",
        "Destacados"
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        tabs.forEach { tab -> val isSelected = tab == selectedTab
            Column {
                Text(
                    text = tab,
                    fontSize = 17.sp,
                    fontWeight = if (isSelected) {
                        FontWeight.Bold
                    } else {
                        FontWeight.Normal
                    },
                    modifier = Modifier.clickable {
                        onTabSelected(tab)
                    }
                )
                if (isSelected) {
                    androidx.compose.foundation.layout.Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .width(40.dp)
                            .height(2.dp)
                            .background(Color.Black)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MediumTabsPreview() {
    MediumTabs(
        selectedTab = "Siguiendo",
        onTabSelected = {}
    )
}
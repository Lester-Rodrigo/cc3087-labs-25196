package com.example.lab05.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab05.data.ArticleRepository
import com.example.lab05.data.TopBarRepository
import com.example.lab05.ui.components.MediumArticle
import com.example.lab05.ui.components.MediumTopBar

@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=440,cutout=double")
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    val articles = ArticleRepository.getList()
    val topBar = TopBarRepository.getTopBar()
    Column(
        modifier = modifier
    ) {
        MediumTopBar(topBar = topBar)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        ) {}
        articles.forEachIndexed { index, article ->
            MediumArticle(
                article = article,
                modifier = Modifier.padding(
                    vertical = 12.dp
                )
            )
            if (index < articles.lastIndex) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray)
                )
            }
        }
    }
}
package com.example.lab05.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab05.data.ArticleRepository
import com.example.lab05.ui.components.MediumArticle
import com.example.lab05.ui.components.MediumTopBar
import com.example.lab05.ui.components.MediumTabs
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.saveable.rememberSaveable

@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=440,cutout=double")
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    var selectedTab by rememberSaveable { mutableStateOf("Para ti") }
    val articles = ArticleRepository.getArticles()
    val visibleArticles = articles.filter { article ->
        when (selectedTab) {
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            // Se usó IA para buscar formas de cómo escrolear sin usal lazy columms
            .verticalScroll(rememberScrollState())
    ) {
        MediumTopBar()
        MediumTabs(
            selectedTab = selectedTab,
            onTabSelected = { newTab -> selectedTab = newTab }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        ) {}
        visibleArticles.forEachIndexed { index, article ->
            MediumArticle(
                article = article,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                )
            )
            if (index < visibleArticles.lastIndex) {
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
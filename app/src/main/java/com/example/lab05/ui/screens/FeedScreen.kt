package com.example.lab05.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign

@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=440,cutout=double")
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    var selectedTab by rememberSaveable { mutableStateOf("Para ti") }
    var searchQuery by rememberSaveable {mutableStateOf("")}
    var showShortReadsOnly by rememberSaveable {mutableStateOf(false)}
    //Prueba b: Variable local con remember
    var applauseCounter by remember { mutableStateOf(0) }
    val articles = ArticleRepository.getArticles()
    val visibleArticles = articles.filter { article ->
        val matchesTab = when (selectedTab) {
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
        val matchesSearch = article.title.contains(
            other = searchQuery,
            ignoreCase = true
        ) || article.author.contains(
            other = searchQuery,
            ignoreCase = true
        )
        val matchesReadingTime = !showShortReadsOnly || article.readingMinutes <= 5
        matchesTab && matchesSearch && matchesReadingTime
    }
    val countResult = visibleArticles.size
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
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { newQuery -> searchQuery = newQuery },
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            label = { Text("Buscar por títulos o autor") },
            singleLine = true
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = showShortReadsOnly,
                onCheckedChange = { isChecked -> showShortReadsOnly = isChecked}
            )
            Text(
                text = "Solo lecturas cortas",
                modifier = Modifier.padding( start = 8.dp)
                    .weight(1f)
            )
            TextButton(
                onClick = {
                    applauseCounter++
                }
            ) {
                Text(
                    text = "Aplaudir · $applauseCounter"
                )
            }
        }
        Text(
            text = if ( countResult == 1) {
                "1 Resultado"
            } else {
                "$countResult resultados"
            },
            modifier = Modifier.fillMaxWidth()
                .padding(
                horizontal = 16.dp,
                vertical = 4.dp
            ),
            textAlign = TextAlign.End
        )
       if ( visibleArticles.isEmpty()) {
           Column(
               modifier = Modifier.fillMaxWidth()
                   .padding(32.dp),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Text(
                   text = "No se encontraron artículos",
                   fontWeight = FontWeight.Bold
               )
               Text(
                   text = "Cambie la pestaña, su búsqueda o el filtro usado.",
                   modifier = Modifier.padding( top = 8.dp)
               )
           }
       } else {
           visibleArticles.forEachIndexed { index, article ->
               MediumArticle(
                   article = article,
                   modifier = Modifier.fillMaxWidth()
                       .padding(
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
}
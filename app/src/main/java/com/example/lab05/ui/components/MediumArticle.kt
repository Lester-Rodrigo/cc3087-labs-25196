package com.example.lab05.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05.model.Article
import com.example.lab05.ui.theme.Gray

@Composable
fun MediumArticle(
    article: Article,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Article name
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(article.boxColor)
                ) { }
                Text(
                    text = article.author,
                    color = Gray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = article.title,
                    fontSize = 24.sp,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(article.boxColor)
                ){}
            }
            Text(
                text = article.excerpt,
                textAlign = TextAlign.Justify
            )
            Text(
                text = "${article.readingMinutes} min de lectura · ${article.date}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediumArticlePreview(
) {
    val author = "Ana Robles"
    val title = "Por qué su primera app se siente lenta"
    val excerpt = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde"
    val readingMinutes = 5
    val date = "12 dic"
    Row {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Article name
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                ) {}
                Text(
                    text = author,
                    color = Gray
                )
            }
            Text(
                text = title,
                fontSize = 24.sp
            )
            Text(
                text = excerpt,
                textAlign = TextAlign.Justify
            )
            Text(
                text = "$readingMinutes min de lectura · $date"
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray)
            ) {}
        }
    }
}
package com.example.lab05.data


import androidx.compose.ui.graphics.Color
import com.example.lab05.model.Article

object ArticleRepository {
    fun getList() = listOf<Article>(
        Article (
            author = "Ana Robles",
            title = "Pollo dorarito al horno con cocción lenta",
            excerpt = "El mejor pollo que podras probar en tu vida",
            readingMinutes = 5,
            date = "12 dic",
            isAuthorFollowed = true,
            isFeatured = false,
            boxColor = Color.Red
        ),
        Article (
            author = "Pablo Hernández",
            title = "Pizza instantánea, pero sabe a recien hecha",
            excerpt = "Secreto sobre cómo mejorar el sabor de cualquier pizza instantánea",
            readingMinutes = 12,
            date = "9 enero",
            isAuthorFollowed = false,
            isFeatured = true,
            boxColor = Color.Blue
        ),
        Article (
            author = "Timoteo Sanches",
            title = "Sandwich de viaje",
            excerpt = "Te enseño a hacer sandwiches duraderos, para que viaje a donde viajes no se arruinen ni se mojen ",
            readingMinutes = 9,
            date = "15 Abril",
            isAuthorFollowed = true,
            isFeatured = true,
            boxColor = Color.Yellow
        ),
    )
}
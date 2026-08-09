package com.example.lab05.data


import androidx.compose.ui.graphics.Color
import com.example.lab05.model.Article

object ArticleRepository {
    fun getList() = listOf<Article>(
        Article (
            name = "Ana Robles",
            title = "Pollo dorarito al horno con cocción lenta",
            resume = "El mejor pollo que podras probar en tu vida",
            readTime = 5,
            date = "12 dic",
            boxColor = Color.Red
        ),
        Article (
            name = "Pablo Hernández",
            title = "Pizza instantánea, pero sabe a recien hecha",
            resume = "Secreto sobre cómo mejorar el sabor de cualquier pizza instantánea",
            readTime = 12,
            date = "9 enero",
            boxColor = Color.Blue
        ),
        Article (
            name = "Timoteo Sanches",
            title = "Sandwich de viaje",
            resume = "Te enseño a hacer sandwiches duraderos, para que viaje a donde viajes no se arruinen ni se mojen ",
            readTime = 9,
            date = "15 Abril",
            boxColor = Color.Yellow
        ),
    )
}
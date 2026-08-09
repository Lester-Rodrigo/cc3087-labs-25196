package com.example.lab05.data

import com.example.lab05.model.Article

object ArticleRepository {
    fun getList() = listOf<Article>(
        Article (
            name = "Ana Robles",
            title = "Por qué su primera app se siente lenta",
            resume = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde",
            readTime = 5,
            date = "12 dic"
        ),
        Article (
            name = "Ana Robles",
            title = "Por qué su primera app se siente lenta",
            resume = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde",
            readTime = 5,
            date = "12 dic"
        ),
        Article (
            name = "Ana Robles",
            title = "Por qué su primera app se siente lenta",
            resume = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde",
            readTime = 5,
            date = "12 dic"
        ),
    )
}
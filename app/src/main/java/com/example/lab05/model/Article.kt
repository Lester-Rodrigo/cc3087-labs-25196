package com.example.lab05.model

import androidx.compose.ui.graphics.Color

data class Article(
    val author: String,
    val title: String,
    val excerpt: String,
    val readingMinutes: Int,
    val date: String,
    val isAuthorFollowed: Boolean,
    val isFeatured: Boolean,
    val boxColor: Color
)

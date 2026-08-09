package com.example.lab05.model

import androidx.compose.ui.graphics.Color

data class Article(
    val name: String,
    val title: String,
    val resume: String,
    val readTime: Int,
    val date: String,
    val boxColor: Color
)

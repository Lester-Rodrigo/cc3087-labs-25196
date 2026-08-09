package com.example.lab05.data

import com.example.lab05.model.Tabs

object TabsRepository {

    fun getTabs() = Tabs(
        option1 = "Para ti",
        option2 = "Menú",
        option3 = "Temporada"
    )
}
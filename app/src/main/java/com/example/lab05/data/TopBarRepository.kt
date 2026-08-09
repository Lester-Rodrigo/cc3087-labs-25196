package com.example.lab05.data

import com.example.lab05.model.TopBar

object TopBarRepository {
        fun getTopBar() = TopBar(
            title = "Lecturas",
            logo = "M",
            extraText = "Ordenar"
        )
}
package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.models.Book
import com.example.myapplication.models.Genre


val genres = listOf(
    Genre(1, "Informatyka"),
    Genre(2, "Fizyka"),
    Genre(3, "Inne")
)

val books = listOf(
    Book("Wiedźmin", 1,"Andrzej Sapkowski", "Saga o zabójcy potworów.", R.drawable.gra_o_tron),
    Book("1984", 2,"George Orwell", "Dystopijna wizja totalitaryzmu.", R.drawable.plane),
    Book("Mały Książę", 3,"Antoine de Saint-Exupéry", "Filozoficzna bajka o dorosłości.", R.drawable.informatyka_podrecznik),
    Book("Lśnienie", 1,"Stephen King", "Horror rozgrywający się w opuszczonym hotelu.", R.drawable.deep_learning)
)
package com.example.myapplication.models

data class Book(
    val title: String,
    val genreId: Int,
    val author: String,
    val description: String,
    val imageId: Int,
    var isFavourite: Boolean = false
)

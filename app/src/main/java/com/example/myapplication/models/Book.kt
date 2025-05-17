package com.example.myapplication.models

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class Book(
    val title: String,
    val genreId: Int,
    val author: String,
    val description: String,
    val imageId: Int,
    var isFavourite: Boolean = false
){
    var isFavouriteState by mutableStateOf(isFavourite)
}

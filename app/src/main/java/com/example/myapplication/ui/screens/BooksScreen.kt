package com.example.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.models.Book
import androidx.compose.foundation.lazy.items
import com.example.myapplication.data.books
import com.example.myapplication.data.genres
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

@Composable
fun BooksScreen(genreId: Int) {
    val initialBooks = filterBooksByGenre(books, genreId)
    var bookList by remember { mutableStateOf(initialBooks) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(bookList) { book ->
            BookCard(book,
                onToggleFavourite = {
                    val index = books.indexOfFirst { it.title == book.title }
                    if (index != -1) {
                        book.isFavouriteState = !book.isFavouriteState
                    }
            })
        }
    }
}

@Composable
fun BookCard(book: Book, onToggleFavourite: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = book.imageId),
                contentDescription = "Okładka książki",
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp)
                    .padding(end = 16.dp)
            )

            Column(modifier = Modifier
                .weight(1f)
                .padding(8.dp)) {
                Text(text = book.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "Autor: ${book.author}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = book.description, fontSize = 14.sp)
            }

            IconButton(onClick = onToggleFavourite) {
                Icon(
                    imageVector = if (book.isFavouriteState) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Ulubione",
                    tint = if (book.isFavouriteState) Color.Red else Color.Gray
                )
            }
        }
    }
}

fun filterBooksByGenre(books: List<Book>, genreId: Int): List<Book> {
    return books.filter { it.genreId == genreId }
}
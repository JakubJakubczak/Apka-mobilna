package com.example.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.genres
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.sp

@Composable
fun GenresScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(genres) { genre ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("books/${genre.id}") } // ✅ tutaj poprawka
            ) {
                Text(
                    text = genre.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


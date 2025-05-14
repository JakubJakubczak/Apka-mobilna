package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    var isShadowed by remember { mutableStateOf(false) }
    val shadowSize = if (isShadowed) 16.dp else 0.dp

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Obrazek
        Image(
            painter = painterResource(R.drawable.airplane),
            contentDescription = "Obrazek samolotu",
            modifier = Modifier
                .width(300.dp)
                .shadow(shadowSize)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Opis od razu po obrazku
        Text(
            text = "To jest obrazek samolotu.",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}

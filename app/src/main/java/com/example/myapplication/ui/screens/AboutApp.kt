package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutAppScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "About app",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bookead to prosta i intuicyjna aplikacja mobilna, której celem jest pomoc w odkrywaniu wartościowych książek.\n" +
                        "\n" +
                        "Aplikacja została stworzona z naciskiem na czytelność, prostotę i nowoczesny wygląd oparty na Jetpack Compose.\n" +
                        "\n" +
                        "Autor: Jakub Jakubczak\n" +
                        "\n" +
                        "Wersja: 1.0\n",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

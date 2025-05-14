package com.example.myapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    onPlanClick: (Int) -> Unit = {}, // kliknięcie planu
) {
    val ctx = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            // Jeśli będziesz chciał dodać FAB w przyszłości
            // AppFAB( onClick = { Toast.makeText(ctx, "Not implemented yet!", Toast.LENGTH_SHORT).show() })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // 3 plany treningowe u góry
            item {
                Text(
                    text = "Wybierz plan treningowy:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                PlanCard(title = "Plan A - Siła", onClick = { onPlanClick(1) })
                PlanCard(title = "Plan B - Masa", onClick = { onPlanClick(2) })
                PlanCard(title = "Plan C - Redukcja", onClick = { onPlanClick(3) })
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Opis układania planów
            item {
                Text(
                    text = "Jak układać plany treningowe?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Dobry plan treningowy powinien być dostosowany do Twoich celów, poziomu zaawansowania i czasu, jaki możesz poświęcić na ćwiczenia. Pamiętaj o progresji obciążenia i regeneracji!",
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.padding(bottom = 32.dp)
                )
            }

            // Twoje poprzednie testowe elementy (jeśli chcesz je zostawić)
//            items((1..10).toList()) { item ->
//                Text(
//                    text = "Item number $item",
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    fontWeight = FontWeight.Bold,
//                    style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
//                )
//            }
        }
    }
}

@Composable
fun PlanCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen()
}

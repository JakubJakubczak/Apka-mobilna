package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PlanAScreen() {
    Text(
        text = "Plan A - Trening na siłę",
        modifier = Modifier.fillMaxSize(),
        fontSize = 32.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun PlanBScreen() {
    Text(
        text = "Plan B - Trening na masę",
        modifier = Modifier.fillMaxSize(),
        fontSize = 32.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun PlanCScreen() {
    Text(
        text = "Plan C - Trening na redukcję",
        modifier = Modifier.fillMaxSize(),
        fontSize = 32.sp,
        textAlign = TextAlign.Center
    )
}

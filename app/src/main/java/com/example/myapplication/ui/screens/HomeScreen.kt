package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.viewinterop.AndroidView
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.ui.platform.LocalContext
import android.net.Uri

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tekst nad obrazkiem
        Text(
            text = "Witamy w aplikacji do rekomendacji książek!",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

//        Image(
//            painter = painterResource(R.drawable.airplane),
//            contentDescription = "Grafika aplikacji",
//            modifier = Modifier
//                .width(300.dp)
//                .shadow(8.dp)
//        )

        VideoPlayer(modifier = Modifier.fillMaxWidth().height(300.dp))


        // Tekst pod obrazkiem
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Przeglądaj polecane tytuły i znajdź coś dla siebie.",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
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

@Composable
fun VideoPlayer(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    AndroidView(
        factory = {
            VideoView(it).apply {
                val videoUri = Uri.parse("android.resource://${context.packageName}/raw/book_video")
                setVideoURI(videoUri)
                setMediaController(MediaController(context).also { controller ->
                    controller.setAnchorView(this)
                })
                start()
            }
        },
        modifier = modifier
    )
}
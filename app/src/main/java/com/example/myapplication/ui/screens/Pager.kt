package com.example.myapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R


@Composable
fun PagerScreen() {
    val ctx = LocalContext.current
    val imageIds = intArrayOf(
        R.drawable.mariusz1,
        R.drawable.mariusz2,
        R.drawable.mariusz3,)
    val pagerState : PagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        imageIds.size
    }

    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = imageIds[page]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "ID="+imageIds[page].toString(), modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.titleMedium)
            Button(onClick = { Toast.makeText(ctx,"Not implemented yet!", Toast.LENGTH_SHORT).show() }) {
                Text(text = "Set as main image")
            }
        }
    }
}

@Preview
@Composable
fun PagerScreenPreview() {
    PagerScreen()
}
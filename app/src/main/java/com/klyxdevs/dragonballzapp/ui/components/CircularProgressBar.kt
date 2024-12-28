package com.klyxdevs.dragonballzapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.klyxdevs.dragonballzapp.ui.core.colors.Orange

@Composable
fun CircularProgressBar(color: Color, size: Dp = 36.dp) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .size(size), contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(color = color)
            Text("Loading...", color = Orange, modifier = Modifier.padding(top = 8.dp))
        }
    }
}
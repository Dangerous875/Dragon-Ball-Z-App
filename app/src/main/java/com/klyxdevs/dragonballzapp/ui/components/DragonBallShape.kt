package com.klyxdevs.dragonballzapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.klyxdevs.dragonballzapp.ui.core.colors.Orange

@Composable
fun DragonBallShape() {
    Box(
        modifier = Modifier
            .size(180.dp)
            .clip(CircleShape)
            .background(Orange)
            .border(
                BorderStroke(
                    6.dp, Brush.horizontalGradient(
                        listOf(
                            Color.White.copy(alpha = 0.3f),
                            Orange,
                            Orange,
                        )
                    )
                ), CircleShape
            ), contentAlignment = Alignment.Center
    ) {
        Row {
            Column {
                DragonBallStar()
                DragonBallStar()
            }
            Spacer(modifier = Modifier.width(6.dp))
            Column {
                DragonBallStar()
                DragonBallStar()
            }
        }
    }
}
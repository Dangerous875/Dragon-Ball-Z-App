package com.klyxdevs.dragonballzapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.klyxdevs.dragonballzapp.R

@Composable
fun DragonBallStar() {
    Icon(
        modifier = Modifier
            .padding(10.dp)
            .size(24.dp),
        painter = androidx.compose.ui.res.painterResource(id = R.drawable.ic_star),
        contentDescription = "",
        tint = Color.Red
    )
}
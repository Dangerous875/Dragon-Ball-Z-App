package com.klyxdevs.dragonballzapp.ui.screens.fullScreenImage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.klyxdevs.dragonballzapp.data.remote.model.Transformation
import com.klyxdevs.dragonballzapp.ui.components.DragonBallShapeDetail
import com.klyxdevs.dragonballzapp.ui.core.colors.Orange

@Composable
fun FullScreenImage(character : Transformation){
    Card(
        border = BorderStroke(1.dp, Color.Gray.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxSize().background(Orange),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.weight(0.8f).fillMaxSize()){
                Box(modifier = Modifier.align(Alignment.TopStart).padding(start = 8.dp, top = 8.dp)){
                    DragonBallShapeDetail()
                }
                Box(modifier = Modifier.align(Alignment.TopEnd).padding(end = 8.dp, top = 8.dp)){
                    DragonBallShapeDetail()
                }
                Box(modifier = Modifier.align(Alignment.BottomStart).padding(start = 8.dp, bottom = 8.dp)){
                    DragonBallShapeDetail()
                }
                Box(modifier = Modifier.align(Alignment.BottomEnd).padding(end = 8.dp, bottom = 8.dp)){
                    DragonBallShapeDetail()
                }
                AsyncImage(
                    modifier = Modifier.align(Alignment.Center).fillMaxSize(),
                    model = character.image, contentDescription = "")

            }

            Text(
                text = "Transformation: ${character.name} ",
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = "Power: ${character.ki} ",
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }
    }
}
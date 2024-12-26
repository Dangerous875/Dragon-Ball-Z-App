package com.klyxdevs.dragonballzapp.ui.screens.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel
import com.klyxdevs.dragonballzapp.ui.components.CircularProgressBar
import com.klyxdevs.dragonballzapp.ui.components.DragonBallShape
import com.klyxdevs.dragonballzapp.ui.core.colors.BackgroundPrimary
import com.klyxdevs.dragonballzapp.ui.core.colors.Orange
import com.klyxdevs.dragonballzapp.ui.screens.homeScreen.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(navigateToDetail: (CharacterModel) -> Unit, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val isLoading by viewModel.isLoading.collectAsState()
    val characters by viewModel.characters.collectAsState()

    if (isLoading) {
        CircularProgressBar(Orange)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundPrimary.copy(alpha = 0.8f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Dragon Ball Z",
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.White
            )
            LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp)) {
                items(characters) { character ->
                    CharacterItem(character) {
                        navigateToDetail(character)
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: CharacterModel, onItemClick: (CharacterModel) -> Unit) {
    Box(
        Modifier
            .padding(16.dp)
            .height(250.dp)
            .clickable { onItemClick(character) },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1f))
            Card(
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20),
                border = BorderStroke(4.dp, Orange)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = character.name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Text(text = character.race, fontSize = 20.sp, fontStyle = FontStyle.Italic)
                }
            }
        }
        DragonBallShape()
        AsyncImage(
            model = character.image, contentDescription = "", modifier = Modifier.size(180.dp)
        )
    }
}

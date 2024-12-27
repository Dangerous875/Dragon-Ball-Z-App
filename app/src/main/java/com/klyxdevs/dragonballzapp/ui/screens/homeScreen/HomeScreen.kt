package com.klyxdevs.dragonballzapp.ui.screens.homeScreen

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun HomeScreen(
    navigateToDetail: (CharacterModel) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as Activity
    val isLoading by viewModel.isLoading.collectAsState()
    val characters by viewModel.characters.collectAsState()

    if (isLoading) {
        CircularProgressBar(Orange)
    } else {
        Scaffold(topBar = {
            TopBar(
                tittle = "Dragon Ball Z App",
                activity = activity
            )
        }) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundPrimary.copy(alpha = 0.8f))
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(tittle: String, activity: Activity) {
    TopAppBar(
        modifier = Modifier
            .border(width = 2.dp, color = Orange)
            .background(BackgroundPrimary),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(modifier = Modifier.size(35.dp)) {
                    DragonBallShape()
                }
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = tittle,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 25.sp
                )
                Box(modifier = Modifier.size(35.dp)) {
                    DragonBallShape()
                }
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(Color.DarkGray),
        actions = {
            IconButton(onClick = { activity.finishAffinity() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = null,
                    tint = Orange
                )
            }
        }
    )
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

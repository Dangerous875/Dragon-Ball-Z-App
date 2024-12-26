package com.klyxdevs.dragonballzapp.ui.screens.detailScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel

@Composable
fun DetailScreen(character: CharacterModel) {

    Text(character.name)

}
package com.klyxdevs.dragonballzapp.ui.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.klyxdevs.dragonballzapp.domain.model.Characters
import com.klyxdevs.dragonballzapp.ui.screens.homeScreen.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val isLoading by viewModel.isLoading.collectAsState()
    val characters by viewModel.characters.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Home Screen")
        ContentView(isLoading, characters)

    }

}

@Composable
fun ContentView(loading: Boolean, characters: List<Characters>) {
    if (loading) {
        CircularProgressIndicator()
    }else{
        Text(text = characters.toString())
    }
}

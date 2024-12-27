package com.klyxdevs.dragonballzapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.klyxdevs.dragonballzapp.data.remote.model.Transformation
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel
import com.klyxdevs.dragonballzapp.ui.core.NavRoutes.*
import com.klyxdevs.dragonballzapp.ui.screens.detailScreen.DetailScreen
import com.klyxdevs.dragonballzapp.ui.screens.fullScreenImage.FullScreenImage
import com.klyxdevs.dragonballzapp.ui.screens.homeScreen.HomeScreen
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreenRoute) {
        composable<HomeScreenRoute> {
            HomeScreen(navigateToDetail = { character ->
                navController.navigate(
                    DetailScreenRoute(character.encodingObject())
                )
            })
        }
        composable<DetailScreenRoute> {
            val safeArgs = it.toRoute<DetailScreenRoute>()
            val character = Json.decodeFromString<CharacterModel>(safeArgs.character)
            DetailScreen(
                character,
                navigateBack = { navController.popBackStack() },
                navigateFullScreen = { characterTransformation ->
                    navController.navigate(FullScreenRoute(characterTransformation.encodingObject()))
                })
        }

        composable<FullScreenRoute> {
            val safeArgs = it.toRoute<FullScreenRoute>()
            val character = Json.decodeFromString<Transformation>(safeArgs.character)
            FullScreenImage(character)
        }
    }
}
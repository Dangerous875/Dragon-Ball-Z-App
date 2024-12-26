package com.klyxdevs.dragonballzapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel
import com.klyxdevs.dragonballzapp.ui.core.NavRoutes.DetailScreenRoute
import com.klyxdevs.dragonballzapp.ui.core.NavRoutes.HomeScreenRoute
import com.klyxdevs.dragonballzapp.ui.screens.detailScreen.DetailScreen
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
            DetailScreen(character)
        }
    }
}
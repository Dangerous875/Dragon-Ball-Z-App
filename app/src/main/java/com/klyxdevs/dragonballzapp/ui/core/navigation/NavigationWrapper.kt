package com.klyxdevs.dragonballzapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.klyxdevs.dragonballzapp.ui.core.NavRoutes.*
import com.klyxdevs.dragonballzapp.ui.screens.homeScreen.HomeScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.klyxdevs.dragonballzapp.ui.screens.detailScreen.DetailScreen

@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreenRoute){
        composable<HomeScreenRoute> { HomeScreen() }
        composable<DetailScreenRoute> {
            val safeArgs = it.toRoute<DetailScreenRoute>()
            DetailScreen(safeArgs.id)
        }
    }
}
package com.klyxdevs.dragonballzapp.ui.core

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes {
    @Serializable
    data object HomeScreenRoute : NavRoutes()
    @Serializable
    data class DetailScreenRoute(val id: Int) : NavRoutes()
}
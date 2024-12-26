package com.klyxdevs.dragonballzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.klyxdevs.dragonballzapp.ui.core.navigation.NavigationWrapper
import com.klyxdevs.dragonballzapp.ui.theme.DragonBallZAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DragonBallZAppTheme {
                NavigationWrapper()
            }
        }
    }
}

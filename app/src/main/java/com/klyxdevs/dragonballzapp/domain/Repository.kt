package com.klyxdevs.dragonballzapp.domain

import com.klyxdevs.dragonballzapp.data.remote.model.CharactersResponse
import com.klyxdevs.dragonballzapp.domain.model.Characters

interface Repository {

    suspend fun getAllCharactersFromApi(): List<Characters>
}
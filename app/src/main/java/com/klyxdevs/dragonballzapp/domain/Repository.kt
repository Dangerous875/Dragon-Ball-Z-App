package com.klyxdevs.dragonballzapp.domain

import com.klyxdevs.dragonballzapp.domain.model.CharacterModel

interface Repository {

    suspend fun getAllCharactersFromApi(): List<CharacterModel>

    suspend fun getAllCharactersFromDB(): List<CharacterModel>

    suspend fun getCharacterByIdFromDB(id: Int): CharacterModel

    suspend fun insertCharactersDB(characters: List<CharacterModel>)
}
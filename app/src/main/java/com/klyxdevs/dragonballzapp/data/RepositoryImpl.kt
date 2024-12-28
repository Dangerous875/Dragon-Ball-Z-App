package com.klyxdevs.dragonballzapp.data

import com.klyxdevs.dragonballzapp.data.database.dao.CharacterDao
import com.klyxdevs.dragonballzapp.data.remote.service.ApiServiceDBZ
import com.klyxdevs.dragonballzapp.domain.Repository
import com.klyxdevs.dragonballzapp.domain.model.CharacterDetailModel
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiServiceDBZ: ApiServiceDBZ,
    private val characterDao: CharacterDao
) : Repository {

    override suspend fun getAllCharactersFromApi(): List<CharacterModel> {
        val characters = apiServiceDBZ.getAllCharactersFromApi()
        return if (characters.isNotEmpty()) {
            characters.map { it.toDomain() }
        } else {
            emptyList()
        }
    }

    override suspend fun getAllCharactersFromDB(): List<CharacterModel> {
        val charactersFromDB = characterDao.getAllCharactersFromDB()
        return if (charactersFromDB.isNotEmpty()) {
            charactersFromDB.map { it.toDomain() }
        } else {
            emptyList()
        }
    }

    override suspend fun getCharacterByIdFromDB(id: Int): CharacterModel {
        val charactersFromDB = characterDao.getCharacterByIdFromDB(id)
        return charactersFromDB.toDomain()
    }

    override suspend fun insertCharactersDB(characters: List<CharacterModel>) {
        characterDao.insertCharactersDB(characters.map { it.toEntity() })
    }

    override suspend fun getCharacterByIdFromApi(id: Int): CharacterDetailModel? {
        val character = apiServiceDBZ.getCharacterByIdFromApi(id)
        return character?.toDomain()
    }
}
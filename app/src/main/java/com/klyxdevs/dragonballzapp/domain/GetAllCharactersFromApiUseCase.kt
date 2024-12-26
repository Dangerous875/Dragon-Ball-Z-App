package com.klyxdevs.dragonballzapp.domain

import android.util.Log
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllCharactersFromApiUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): List<CharacterModel> {
        val charactersDB = repository.getAllCharactersFromDB()
        Log.i("CharactersDB", charactersDB.toString())
        if (charactersDB.isNotEmpty()) {
            return charactersDB
        } else {
            val characterApi = repository.getAllCharactersFromApi()
            withContext(Dispatchers.IO) {
                repository.insertCharactersDB(characterApi)
            }
            return characterApi
        }
    }
}
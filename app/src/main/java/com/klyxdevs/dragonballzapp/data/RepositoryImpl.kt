package com.klyxdevs.dragonballzapp.data

import com.klyxdevs.dragonballzapp.data.remote.service.ApiServiceDBZ
import com.klyxdevs.dragonballzapp.domain.Repository
import com.klyxdevs.dragonballzapp.domain.model.Characters
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiServiceDBZ: ApiServiceDBZ) : Repository {
    override suspend fun getAllCharactersFromApi(): List<Characters> {
        return apiServiceDBZ.getAllCharactersFromApi().map { it.toDomain() }
    }
}
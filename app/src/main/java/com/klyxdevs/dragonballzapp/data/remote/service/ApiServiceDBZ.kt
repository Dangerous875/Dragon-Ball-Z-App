package com.klyxdevs.dragonballzapp.data.remote.service

import com.klyxdevs.dragonballzapp.data.remote.ApiClientDBZ
import com.klyxdevs.dragonballzapp.data.remote.model.CharactersResponse
import javax.inject.Inject

class ApiServiceDBZ @Inject constructor(private val apiService: ApiClientDBZ) {

    suspend fun getAllCharactersFromApi(): List<CharactersResponse> =
        apiService.getAllCharactersFromApi().body()?.characters ?: emptyList()
}
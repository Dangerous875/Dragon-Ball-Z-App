package com.klyxdevs.dragonballzapp.data.remote

import com.klyxdevs.dragonballzapp.data.remote.model.CharacterDetailResponse
import com.klyxdevs.dragonballzapp.data.remote.model.CharactersWrapperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClientDBZ {

    @GET("characters?limit=58")
    suspend fun getAllCharactersFromApi(): Response<CharactersWrapperResponse>

    @GET("characters/{id}")
    suspend fun getCharacterByIdFromApi(@Path("id") id: Int): Response<CharacterDetailResponse>
}
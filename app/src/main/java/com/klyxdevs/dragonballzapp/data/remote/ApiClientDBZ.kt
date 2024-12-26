package com.klyxdevs.dragonballzapp.data.remote

import com.klyxdevs.dragonballzapp.data.remote.model.CharactersWrapperResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClientDBZ {

    @GET("characters?limit=58")
    suspend fun getAllCharactersFromApi(): Response<CharactersWrapperResponse>
}
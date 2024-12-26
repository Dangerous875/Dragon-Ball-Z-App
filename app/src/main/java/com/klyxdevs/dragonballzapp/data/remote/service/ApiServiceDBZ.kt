package com.klyxdevs.dragonballzapp.data.remote.service

import android.util.Log
import com.klyxdevs.dragonballzapp.data.remote.ApiClientDBZ
import com.klyxdevs.dragonballzapp.data.remote.model.CharactersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiServiceDBZ @Inject constructor(private val apiService: ApiClientDBZ) {

    suspend fun getAllCharactersFromApi(): List<CharactersResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getAllCharactersFromApi()
            if (response.isSuccessful) {
                response.body()?.characters ?: emptyList()
            } else {
                Log.e("API FAILED", "Error: ${response.code()} - ${response.message()}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("API FAILED", "Unexpected error: ${e.message}")
            emptyList()
        }
    }

}
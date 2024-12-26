package com.klyxdevs.dragonballzapp.domain

import javax.inject.Inject

class GetAllCharactersFromApiUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() = repository.getAllCharactersFromApi()
}
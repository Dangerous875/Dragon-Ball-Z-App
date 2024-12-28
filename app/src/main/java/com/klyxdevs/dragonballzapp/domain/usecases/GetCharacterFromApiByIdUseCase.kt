package com.klyxdevs.dragonballzapp.domain.usecases

import com.klyxdevs.dragonballzapp.domain.Repository
import com.klyxdevs.dragonballzapp.domain.model.CharacterDetailModel
import javax.inject.Inject

class GetCharacterFromApiByIdUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(id: Int): CharacterDetailModel? =
        repository.getCharacterByIdFromApi(id)
}
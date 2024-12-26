package com.klyxdevs.dragonballzapp.data.remote.model

import com.klyxdevs.dragonballzapp.domain.model.CharacterModel

data class CharactersResponse(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String
) {
    fun toDomain() = CharacterModel(
        id,
        name, ki,
        maxKi,
        race,
        gender,
        description,
        image,
        affiliation
    )
}

package com.klyxdevs.dragonballzapp.data.remote.model

import com.klyxdevs.dragonballzapp.domain.model.CharacterDetailModel

data class CharacterDetailResponse(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String,
    val originPlanet: OriginPlanet,
    val transformations: List<Transformation>
) {
    fun toDomain(): CharacterDetailModel {
        return CharacterDetailModel(
            id,
            name,
            ki,
            maxKi,
            race,
            gender,
            description,
            image,
            affiliation,
            originPlanet,
            transformations
        )
    }
}


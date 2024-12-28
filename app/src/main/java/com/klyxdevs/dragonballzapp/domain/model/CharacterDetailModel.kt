package com.klyxdevs.dragonballzapp.domain.model

import com.klyxdevs.dragonballzapp.data.remote.model.OriginPlanet
import com.klyxdevs.dragonballzapp.data.remote.model.Transformation

data class CharacterDetailModel(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String,
    val originPlanet : OriginPlanet,
    val transformations : List<Transformation>
)

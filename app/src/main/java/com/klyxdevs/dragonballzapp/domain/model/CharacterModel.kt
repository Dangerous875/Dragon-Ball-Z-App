package com.klyxdevs.dragonballzapp.domain.model

import com.klyxdevs.dragonballzapp.data.database.entities.CharacterEntity
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class CharacterModel(
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
    fun encodingObject(): String {
        return Json.encodeToString(this)
    }

    fun toEntity() =
        CharacterEntity(id, name, ki, maxKi, race, gender, description, image, affiliation)

}

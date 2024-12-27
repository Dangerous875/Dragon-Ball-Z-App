package com.klyxdevs.dragonballzapp.data.remote.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Transformation(
    val id : Int,
    val name : String,
    val image : String,
    val ki : String
) {
    fun encodingObject(): String {
        return Json.encodeToString(this)
    }
}

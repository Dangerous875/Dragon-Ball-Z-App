package com.klyxdevs.dragonballzapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharactersWrapperResponse(
    @SerializedName("items") val characters: List<CharactersResponse>
)

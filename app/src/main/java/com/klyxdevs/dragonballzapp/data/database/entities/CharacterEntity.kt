package com.klyxdevs.dragonballzapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel

@Entity(tableName = "characters")
data class CharacterEntity (
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "ki")
    val ki: String,
    @ColumnInfo(name = "max_ki")
    val maxKi: String,
    @ColumnInfo(name = "race")
    val race: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "affiliation")
    val affiliation: String
){
    fun toDomain() = CharacterModel(
        id,
        name,
        ki,
        maxKi,
        race,
        gender,
        description,
        image,
        affiliation
    )
}
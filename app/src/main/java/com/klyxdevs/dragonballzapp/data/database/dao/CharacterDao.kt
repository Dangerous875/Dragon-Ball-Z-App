package com.klyxdevs.dragonballzapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.klyxdevs.dragonballzapp.data.database.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharactersFromDB(): List<CharacterEntity>

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterByIdFromDB(id: Int): CharacterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharactersDB(characters: List<CharacterEntity>)

}
package com.klyxdevs.dragonballzapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.klyxdevs.dragonballzapp.data.database.dao.CharacterDao
import com.klyxdevs.dragonballzapp.data.database.entities.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class DataBaseZ : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
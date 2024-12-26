package com.klyxdevs.dragonballzapp.di

import android.content.Context
import androidx.room.Room
import com.klyxdevs.dragonballzapp.data.database.DataBaseZ
import com.klyxdevs.dragonballzapp.data.database.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomProvider {

    private const val DATABASE_NAME = "DragonBall-db"

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): DataBaseZ =
        Room.databaseBuilder(context, DataBaseZ::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideCharacterDao(roomDatabase: DataBaseZ): CharacterDao = roomDatabase.characterDao()
}
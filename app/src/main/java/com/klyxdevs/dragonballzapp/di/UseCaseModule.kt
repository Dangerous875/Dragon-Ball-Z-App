package com.klyxdevs.dragonballzapp.di

import com.klyxdevs.dragonballzapp.data.RepositoryImpl
import com.klyxdevs.dragonballzapp.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindSuperHeroRepository(repository: RepositoryImpl): Repository
}
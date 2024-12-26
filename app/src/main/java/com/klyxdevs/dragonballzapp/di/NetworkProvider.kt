package com.klyxdevs.dragonballzapp.di

import com.klyxdevs.dragonballzapp.data.remote.ApiClientDBZ
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProvider {

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dragonball-api.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiClientDBZ = retrofit.create(ApiClientDBZ::class.java)
}
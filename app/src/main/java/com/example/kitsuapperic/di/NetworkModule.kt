package com.example.kitsuapperic.di

import com.example.kitsuapperic.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideMangaApiService() = retrofitClient.providerMangaApiService()

    @Singleton
    @Provides
    fun provideAnimeApiService() = retrofitClient.providerAnimeApiService()

}
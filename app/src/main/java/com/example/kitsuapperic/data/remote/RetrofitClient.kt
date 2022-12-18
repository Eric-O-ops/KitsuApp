package com.example.kitsuapperic.data.remote

import com.example.kitsuapperic.data.TokenInterceptor
import com.example.kitsuapperic.data.remote.apiservices.AnimeApiService
import com.example.kitsuapperic.data.remote.apiservices.MangaApiService
import com.example.kitsuapperic.data.remote.apiservices.SignInApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClient() = OkHttpClient()
        .newBuilder()
        .addInterceptor(TokenInterceptor())
        .addInterceptor(provideLoggingInspector())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInspector() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun providerMangaApiService(): MangaApiService = retrofit.create(MangaApiService::class.java)

    fun providerAnimeApiService(): AnimeApiService = retrofit.create(AnimeApiService::class.java)

    fun providerSignInApiService(): SignInApiService = retrofit.create(SignInApiService::class.java)


}
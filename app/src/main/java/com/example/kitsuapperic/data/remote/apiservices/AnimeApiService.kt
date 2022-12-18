package com.example.kitsuapperic.data.remote.apiservices

import com.example.kitsuapperic.models.KitsuResponse
import com.example.kitsuapperic.models.anime.AnimeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): KitsuResponse<AnimeModel>
}
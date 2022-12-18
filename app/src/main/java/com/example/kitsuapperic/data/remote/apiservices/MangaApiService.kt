package com.example.kitsuapperic.data.remote.apiservices

import com.example.kitsuapperic.models.KitsuResponse
import com.example.kitsuapperic.models.manga.MangaModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): KitsuResponse<MangaModel>

}
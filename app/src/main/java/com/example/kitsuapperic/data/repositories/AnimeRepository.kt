package com.example.kitsuapperic.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kitsuapperic.base.BaseRepository
import com.example.kitsuapperic.data.remote.apiservices.AnimeApiService
import com.example.kitsuapperic.data.repositories.pagingsources.AnimePagingSources
import com.example.kitsuapperic.models.anime.AnimeModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api: AnimeApiService
) : BaseRepository() {

    fun fetchAnime(): Flow<PagingData<AnimeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                AnimePagingSources(api)
            }, initialKey = 1
        ).flow
    }
}
package com.example.kitsuapperic.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kitsuapperic.base.BaseRepository
import com.example.kitsuapperic.data.remote.apiservices.MangaApiService
import com.example.kitsuapperic.models.manga.MangaModel
import com.example.newsapi.data.repository.pagingsources.MangaPagingSources
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val api: MangaApiService
) : BaseRepository() {

    fun fetchManga(): Flow<PagingData<MangaModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                MangaPagingSources(api)
            }, initialKey = 1
        ).flow
    }
}
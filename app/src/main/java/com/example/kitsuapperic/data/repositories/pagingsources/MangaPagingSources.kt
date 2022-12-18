package com.example.newsapi.data.repository.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kitsuapperic.data.remote.apiservices.MangaApiService
import com.example.kitsuapperic.models.manga.MangaModel
import retrofit2.HttpException
import java.io.IOException

class MangaPagingSources(
    private val mangaApiService: MangaApiService
) : PagingSource<Int, MangaModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaModel> {
        val position = params.key ?: 1
        val pageLimit = 20
        val pageOffset = position - 1


        return try {
            val response = mangaApiService.fetchManga(pageLimit, pageOffset)
            val nextPage = response.links.next
            val nextPageNumber =
                if (nextPage == null) null
                else position + pageLimit

            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MangaModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
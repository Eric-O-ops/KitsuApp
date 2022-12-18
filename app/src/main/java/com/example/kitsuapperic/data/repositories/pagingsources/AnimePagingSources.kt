package com.example.kitsuapperic.data.repositories.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kitsuapperic.data.remote.apiservices.AnimeApiService
import com.example.kitsuapperic.models.anime.AnimeModel
import retrofit2.HttpException
import java.io.IOException

class AnimePagingSources(
    private val animeApiService: AnimeApiService
) : PagingSource<Int, AnimeModel>() {

    override fun getRefreshKey(state: PagingState<Int, AnimeModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeModel> {
        val position = params.key ?: 1
        val pageLimit = 20
        val pageOffset = position - 1


        return try {
            val response = animeApiService.fetchAnime(pageLimit, pageOffset)
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
}
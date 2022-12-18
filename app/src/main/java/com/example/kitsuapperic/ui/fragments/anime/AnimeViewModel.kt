package com.example.kitsuapperic.ui.fragments.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsuapperic.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repository: AnimeRepository
): ViewModel() {

    fun fetchAnime() = repository.fetchAnime().cachedIn(viewModelScope)
}
package com.example.kitsuapperic.ui.fragments.main.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsuapperic.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repository: MangaRepository
): ViewModel() {

    fun fetchManga() = repository.fetchManga().cachedIn(viewModelScope)
}
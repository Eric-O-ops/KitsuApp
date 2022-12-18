package com.example.kitsuapperic.ui.fragments.main.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapperic.R
import com.example.kitsuapperic.base.BaseFragment
import com.example.kitsuapperic.databinding.FragmentAnimeBinding
import com.example.kitsuapperic.ui.adapters.AnimeAdapter
import com.example.kitsuapperic.ui.fragments.main.manga.MangaFragment.Companion.SPAN_COUNT
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment
    : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() {
        binding.animeRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT)
            adapter = animeAdapter

        }
    }

    override fun setupSubscribes() {
        lifecycleScope.launch {
            viewModel.fetchAnime().collect {
                animeAdapter.submitData(it)
            }
        }
    }
}
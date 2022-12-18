package com.example.kitsuapperic.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapperic.R
import com.example.kitsuapperic.base.BaseFragment
import com.example.kitsuapperic.databinding.FragmentMangaBinding
import com.example.kitsuapperic.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)

    override val viewModel: MangaViewModel by viewModels()

    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.mangaRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT)
            binding.mangaRecView.layoutManager = layoutManager
            adapter = mangaAdapter

        }
    }

    override fun setupSubscribes() {
        lifecycleScope.launch {
            viewModel.fetchManga().collect {
                mangaAdapter.submitData(it)
            }
        }
    }

    companion object {
        const val SPAN_COUNT = 3
    }
}

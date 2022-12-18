package com.example.kitsuapperic.ui.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsuapperic.ui.fragments.main.anime.AnimeFragment
import com.example.kitsuapperic.ui.fragments.main.manga.MangaFragment

class ViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AnimeFragment()
            }
            1 -> {
                MangaFragment()
            }
            else -> {
                throw Resources.NotFoundException("Not found exception")
            }
        }
    }
}
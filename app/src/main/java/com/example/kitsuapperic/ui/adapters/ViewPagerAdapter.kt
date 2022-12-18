package com.example.kitsuapperic.ui.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsuapperic.ui.fragments.anime.AnimeFragment
import com.example.kitsuapperic.ui.fragments.manga.MangaFragment

class ViewPagerAdapter(
    fragment: FragmentActivity
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
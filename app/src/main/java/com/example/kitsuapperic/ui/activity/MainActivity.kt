package com.example.kitsuapperic.ui.activity

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapperic.R
import com.example.kitsuapperic.databinding.ActivityMainBinding
import com.example.kitsuapperic.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tabLayout = binding.itemTabLayout
        viewPager = binding.itemViewPager2

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout,viewPager) { tab, index ->
            tab.text = when(index) {
                0 -> {
                    "Anime"
                }

                1 -> {
                    "Manga"
                }

                else -> {
                    throw Resources.NotFoundException("Not found exception")
                }
            }
        }.attach()
    }
}
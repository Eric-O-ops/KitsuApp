package com.example.kitsuapperic.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.kitsuapperic.R
import com.example.kitsuapperic.data.locale.preferences.userdata.UserPreferencesData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            userPreferencesData.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.signInFragment)
            }
        }
        navController.graph = navGraph
    }
}
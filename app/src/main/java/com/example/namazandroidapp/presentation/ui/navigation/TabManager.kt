package com.example.namazandroidapp.presentation.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*


class TabManager(private val mainActivity: MainActivity) {

    private val startDestinations = mapOf(
            R.id.navigation_home to R.id.homeFragment,
            R.id.navigation_time to R.id.timeFragment,
            R.id.navigation_location to R.id.locationFragment,
            R.id.navigation_mosques to R.id.mosquesFragment
    )

    private var currentTabId: Int = R.id.navigation_home
    var currentController: NavController? = null
    private var tabHistory = TabHistory().apply { push(R.id.navigation_home) }

    val navHomeController: NavController by lazy {
        mainActivity.findNavController(R.id.homeTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_graph_main).apply {
                startDestination = startDestinations.getValue(R.id.navigation_home)
            }
        }
    }
    private val navTimeController: NavController by lazy {
        mainActivity.findNavController(R.id.timeTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_times_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_time)
            }
        }
    }
    private val navLocationController: NavController by lazy {
        mainActivity.findNavController(R.id.locationTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_location_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_location)
            }
        }
    }

    private val navMosquesController: NavController by lazy {
        mainActivity.findNavController(R.id.mosquesTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_mosque_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_mosques)
            }
        }
    }

    private val homeTabContainer: View by lazy { mainActivity.homeTabContainer }
    private val timeTabContainer: View by lazy { mainActivity.timeTabContainer }
    private val locationTabContainer: View by lazy { mainActivity.locationTabContainer }
    private val mosquesTabContainer: View by lazy { mainActivity.mosquesTabContainer }

    fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(KEY_TAB_HISTORY, tabHistory)
    }

    fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            tabHistory = it.getSerializable(KEY_TAB_HISTORY) as TabHistory

            switchTab(mainActivity.bottomNavigationView.selectedItemId, false)
        }
    }

    fun supportNavigateUpTo(upIntent: Intent) {
        currentController?.navigateUp()
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.currentDestination == null || it.currentDestination?.id == startDestinations.getValue(currentTabId)) {
                if (tabHistory.size > 1) {
                    val tabId = tabHistory.popPrevious()
                    switchTab(tabId, false)
                    mainActivity.bottomNavigationView.menu.findItem(tabId)?.isChecked = true
                } else {
                    mainActivity.finish()
                }
            }
            it.popBackStack()
        } ?: run {
            mainActivity.finish()
        }
    }

    fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        currentTabId = tabId

        when (tabId) {
            R.id.navigation_home -> {
                currentController = navHomeController
                invisibleTabContainerExcept(homeTabContainer)
            }
            R.id.navigation_time -> {
                currentController = navTimeController
                invisibleTabContainerExcept(timeTabContainer)
            }
            R.id.navigation_location -> {
                currentController = navLocationController
                invisibleTabContainerExcept(locationTabContainer)
            }
            R.id.navigation_mosques -> {
                currentController = navMosquesController
                invisibleTabContainerExcept(mosquesTabContainer)
            }
        }
        if (addToHistory) {
            tabHistory.push(tabId)
        }
    }

    private fun invisibleTabContainerExcept(container: View) {
        homeTabContainer.isInvisible = true
        timeTabContainer.isInvisible = true
        locationTabContainer.isInvisible = true
        mosquesTabContainer.isInvisible = true

        container.isInvisible = false
    }

    companion object {
        private const val KEY_TAB_HISTORY = "key_tab_history"
    }
}
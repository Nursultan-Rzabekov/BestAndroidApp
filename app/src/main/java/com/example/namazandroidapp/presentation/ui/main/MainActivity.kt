package com.example.namazandroidapp.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.IMainView
import com.example.namazandroidapp.presentation.presenter.main.MainPresenter
import com.example.namazandroidapp.presentation.ui.BaseActivity
import com.example.namazandroidapp.presentation.ui.navigation.TabManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter

class MainActivity : BaseActivity(), IMainView, BottomNavigationView.OnNavigationItemSelectedListener {

    private val tabManager: TabManager by lazy { TabManager(this) }

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            tabManager.currentController = tabManager.navHomeController
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        tabManager.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tabManager.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        tabManager.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        tabManager.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        tabManager.switchTab(menuItem.itemId)
        return true
    }

}

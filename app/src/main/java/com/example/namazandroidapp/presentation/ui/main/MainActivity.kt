package com.example.namazandroidapp.presentation.ui.main

import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.IMainView
import com.example.namazandroidapp.presentation.presenter.main.MainPresenter
import com.example.namazandroidapp.presentation.ui.BaseActivity
import moxy.presenter.InjectPresenter

class MainActivity : BaseActivity(), IMainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getNavContainerId(): Int = R.id.a_main_nav_container

    override fun onResume() {
        super.onResume()
    }

}

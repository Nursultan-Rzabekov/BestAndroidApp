package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.namazandroidapp.NavigationLocationGraphDirections
import com.example.namazandroidapp.NavigationTimesGraphDirections
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.ITimeView
import com.example.namazandroidapp.presentation.presenter.main.TimePresenter
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter

class TimeFragment: BaseFragment(), ITimeView {

    @InjectPresenter
    lateinit var presenter: TimePresenter

    override fun getLayoutId(): Int = R.layout.fragment_time

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
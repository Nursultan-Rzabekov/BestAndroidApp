package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.namazandroidapp.NavigationGraphMainDirections
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.ILocationView
import com.example.namazandroidapp.presentation.mvpview.main.ISecondView
import com.example.namazandroidapp.presentation.presenter.main.LocationPresenter
import com.example.namazandroidapp.presentation.presenter.main.SecondPresenter
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_second.*
import moxy.presenter.InjectPresenter

class HomeFragment: BaseFragment(), ILocationView {

    @InjectPresenter
    lateinit var presenter: LocationPresenter

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNextPage.setOnClickListener {
            val action = NavigationGraphMainDirections.actionGlobalPageFragment(1, "HomeFragment")
            view.findNavController().navigate(action)
        }
    }

}
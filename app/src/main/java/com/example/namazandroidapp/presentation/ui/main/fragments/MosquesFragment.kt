package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.namazandroidapp.NavigationMosquesGraphDirections
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.IMosquesView
import com.example.namazandroidapp.presentation.presenter.main.MosquesPresenter
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter

class MosquesFragment: BaseFragment(), IMosquesView {

    @InjectPresenter
    lateinit var presenter: MosquesPresenter

    override fun getLayoutId(): Int = R.layout.fragment_mosques

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNextPage.setOnClickListener {
            val action = NavigationMosquesGraphDirections.actionGlobalFirstFragment(1,"TimeFragment")
            view.findNavController().navigate(action)
        }
    }

}
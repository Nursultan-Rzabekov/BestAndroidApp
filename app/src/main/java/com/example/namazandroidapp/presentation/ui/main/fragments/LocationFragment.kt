package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.namazandroidapp.NavigationLocationGraphDirections
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.ILocationView
import com.example.namazandroidapp.presentation.presenter.main.LocationPresenter
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter

class LocationFragment: BaseFragment(), ILocationView {

    @InjectPresenter
    lateinit var presenter: LocationPresenter

    override fun getLayoutId(): Int = R.layout.fragment_location

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
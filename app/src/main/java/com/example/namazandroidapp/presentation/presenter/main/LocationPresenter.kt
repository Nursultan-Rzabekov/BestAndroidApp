package com.example.namazandroidapp.presentation.presenter.main

import com.example.namazandroidapp.presentation.mvpview.main.ILocationView
import com.example.namazandroidapp.presentation.mvpview.main.ISecondView
import com.example.namazandroidapp.presentation.presenter.BasePresenter
import moxy.InjectViewState

@InjectViewState
class LocationPresenter(): BasePresenter<ILocationView>() {

}
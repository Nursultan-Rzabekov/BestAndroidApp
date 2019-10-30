package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.IFirstView
import com.example.namazandroidapp.presentation.presenter.main.FirstPresenter
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_first.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class FirstFragment : BaseFragment(), IFirstView {

    @Inject
    @InjectPresenter
    lateinit var presenter: FirstPresenter

    override fun getLayoutId(): Int = R.layout.fragment_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        f_first_btn_go_second.setOnClickListener { presenter.navigateToSecondScreen() }
    }

    override fun onNavigateToSecond() {
        navigate(R.id.action_firstFragment_to_secondFragment)
    }

    @ProvidePresenter
    fun providePresenter(): FirstPresenter = presenter

}
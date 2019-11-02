package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.ISecondView
import com.example.namazandroidapp.presentation.presenter.main.SecondPresenter
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_second.*
import moxy.presenter.InjectPresenter

class SecondFragment: BaseFragment(), ISecondView {

    @InjectPresenter
    lateinit var presenter: SecondPresenter

    override fun getLayoutId(): Int = R.layout.fragment_second

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        f_second_btn_go_second.setOnClickListener {
//            view.findNavController().navigateUp()
//        }
            //presenter.close() }

        f_first_btn_go_second.setOnClickListener {
            view.findNavController().navigateUp()
        }
    }

    override fun onClose() {
        //view?.findNavController()!!.navigateUp()
    }
}
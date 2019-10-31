package com.example.namazandroidapp.presentation.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.namazandroidapp.NavigationGraphMainDirections
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.main.IPageView
import com.example.namazandroidapp.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_page.*


class PageFragment : BaseFragment(), IPageView {

    private val fragmentArgs: PageFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_page

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = "Page number ${fragmentArgs.pageNumber}, Parent: ${fragmentArgs.pageParent}"

        buttonNextPage.setOnClickListener {
            view.findNavController().navigate(
                    NavigationGraphMainDirections.actionGlobalPageFragment(fragmentArgs.pageNumber + 1, "PageFragment")
            )
        }
    }
}
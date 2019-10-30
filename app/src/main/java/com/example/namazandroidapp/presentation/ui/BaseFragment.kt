package com.example.namazandroidapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.navigation.NavDirections
import com.example.namazandroidapp.R
import com.example.namazandroidapp.presentation.mvpview.IBaseMvpView
import dagger.android.support.DaggerFragment
import moxy.MvpDelegate

abstract class BaseFragment : DaggerFragment(), IBaseMvpView {

    private var mIsStateSaved: Boolean = false
    private var mvpDelegate: MvpDelegate<out BaseFragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMvpDelegate().onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayoutId(), container, false)

    override fun onStart() {
        super.onStart()
        mIsStateSaved = false
        getMvpDelegate().onAttach()
    }

    override fun onResume() {
        super.onResume()
        mIsStateSaved = false
        getMvpDelegate().onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mIsStateSaved = true
        getMvpDelegate().onSaveInstanceState(outState)
        getMvpDelegate().onDetach()
    }

    override fun onStop() {
        super.onStop()
        getMvpDelegate().onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        getMvpDelegate().onDetach()
        getMvpDelegate().onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (activity?.isFinishing == true) {
            getMvpDelegate().onDestroy()
            return
        }

        if (mIsStateSaved) {
            mIsStateSaved = false
            return
        }

        var anyParentIsRemoving = false
        var parent = parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }

        if (isRemoving || anyParentIsRemoving) {
            getMvpDelegate().onDestroy()
        }
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    private fun getBaseActivity(): BaseActivity? =
        if (activity is BaseActivity) activity as BaseActivity else null

    protected fun notImplementedToast() {
        activity?.let { Toast.makeText(it, R.string.not_implemented, Toast.LENGTH_SHORT).show() }
    }

    fun navigate(id: Int, bundle: Bundle? = null) {
        val navController = getBaseActivity()?.getNavController()
        val action = navController?.currentDestination?.getAction(id)
        if (action != null) navController.navigate(id, bundle)
    }

    fun navigate(directions: NavDirections) {
        getBaseActivity()?.getNavController()?.navigate(directions)
    }

    fun navigateUp() {
        getBaseActivity()?.getNavController()?.navigateUp()
    }

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showErrorToast(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    protected fun showAppBar() {
        getBaseActivity()?.showAppBar()
    }

    protected fun hideAppBar() {
        getBaseActivity()?.hideAppBar()
    }

    protected fun setAppBarTitle(@StringRes titleResId: Int) {
        getBaseActivity()?.setAppBarTitle(titleResId)
    }

    protected fun setAppBarTitle(title: String) {
        getBaseActivity()?.setAppBarTitle(title)
    }

    protected fun lockDrawerLayout() {
        getBaseActivity()?.lockDrawerLayout()
    }

    protected fun unlockDrawerLayout() {
        getBaseActivity()?.unlockDrawerLayout()
    }

    fun getMvpDelegate(): MvpDelegate<*> {
        if (mvpDelegate == null) {
            mvpDelegate = MvpDelegate(this)
        }
        return mvpDelegate!!
    }
}